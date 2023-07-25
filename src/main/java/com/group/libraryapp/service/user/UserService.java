package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.UserCreateRequest;
import com.group.libraryapp.dto.user.UserResponse;
import com.group.libraryapp.dto.user.UserUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// JPA 적용을 위한 코드 정리!!
// JdbcTemplate 예제를 주석 처리 하셔도 되요!

/**
 * 객체 : @Entity
 * save(객체) : 저장하는 기능
 * findAll() : DB에서 모든 객체를 가져온다.
 * findById(id) : 특정 id로 객체를 가져온다.
 *
 * 영속성 컨텍스트 - 실습 진행안하고 편하게~ 아 저런게 있구나~~~ 보이지 않는 친구가 있구나..
 * 4가지 스킬을 자기 마음대로 사용한다~
 *    더티 체크 (변경 감지) / 쓰기 지연 / 1차 캐싱 -> 보이지 않는 곳에서 "최적화"
 * JPA에서 온 친구! JdbcTemplate을 사용하면 상관 X
 */
@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  // 트랜잭션 적용 끝!
  @Transactional // 영속성 컨텍스트도 함께 생겼다가 함께 사라집니다! (JPA)
  public void saveUser(UserCreateRequest request) {
    User user = new User(request.getName(), request.getAge());
    userRepository.save(user);
  }

  // select * from user;
  @Transactional
  public List<UserResponse> getUsers() {
    List<User> users = userRepository.findAll();
    List<UserResponse> responses = new ArrayList<>();
    for (User user : users) { // List<User> 안에 User가 하나씩 들어간다.
      UserResponse response = new UserResponse(user.getId(), user.getName(), user.getAge());
      responses.add(response);
    }
    return responses;

//    return userRepository.findAll().stream()
//        .map(UserResponse::new)
//        .collect(Collectors.toList());
  }

  // SELECT를 써서 해당 id를 가진 유저가 있는지 확인 - 없으면 에러
  // UPDATE를 써서 실제 업데이트
  @Transactional
  public void updateUser(UserUpdateRequest request) {
    User user = userRepository.findById(request.getId())
        .orElseThrow();

    user.updateName(request.getName());
  }

  @Transactional
  public void deleteUser(String name) {
    User user = userRepository.findByName(name);
    if (user == null) {
      throw new IllegalArgumentException();
    }
    userRepository.delete(user); // 알아서 UserRepository가 이 user를 제거해줍니다.
  }
}
