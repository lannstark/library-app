package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.UserCreateRequest;
import com.group.libraryapp.dto.user.UserResponse;
import com.group.libraryapp.dto.user.UserUpdateRequest;
import com.group.libraryapp.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * - 과일 가게 사장님을 위해 "과일 정보를 등록할 수 있는 기능"을 만들어주세요.
 * -> Table 만들어야겠다. + POST /fruit + Controller Service Repository
 * - 과일 정보는 이름, 가격, 유통기한이 있습니다.
 * <p>
 * SQL - 저장(Create) / 조회(Read) / 업데이트(Update) / 삭제(Delete)
 * CRUD
 * <p>
 * 서버에서 직접 사용중!
 */
@CrossOrigin
@RestController // 어노테이션 = 마법 1) 이 클래스를 API 진입 지점 / 2) "스프링 빈"으로 등록
public class UserController {

  private final UserService userService;

  // JdbcTemplate은 그냥 가져다가 쓰고 있죠! 우리가 직접 new JdbcTemplate을 안했죠!
  // UserService는 직접 new를 하고 있다!
  // 질문 : UserService도 new를 하지 않고, JdbcTemplate처럼 그냥 가져다 쓸 수 있을까요?!
  // 앗... 안되네!! 왜 안될까요?! -> 그 이유는 UserService가 "스프링 빈"이 아니기 때문!!!
  // UserService를 스프링 빈으로 만들면 바로 가져다 쓸 수 있겠네요?!!
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/user")
  public void saveUser(@RequestBody UserCreateRequest request) {
    userService.saveUser(request);
  }

  // 캐치볼
  // 1. A가 B에게 공을 던진다
  // 2. B가 A의 공을 받는다.
  // 3. B가 다시 A에게 공을 던지고요~
  // 4. A가 B의 공을 받죠.
  @GetMapping("/user")
  public List<UserResponse> getUsers() {
    return userService.getUsers();
  }

  @PutMapping("/user")
  public void updateUser(@RequestBody UserUpdateRequest request) {
    userService.updateUser(request);
  }

  // 어떤 주어진 이름으로 유저가 없으면 에러를!
  // 있으면 삭제를
  @DeleteMapping("/user")
  public void deleteUser(@RequestParam String name) {
    userService.deleteUser(name);
  }

}
