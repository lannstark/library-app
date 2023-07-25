package com.group.libraryapp.controller.calculator;


import com.group.libraryapp.dto.calculator.MultiplyRequest;
import org.springframework.web.bind.annotation.*;

/**
 * 덧셈 기능 (API)를 만들건데
 * API 명세를 정해야 한다!!
 *
 * - HTTP Method : GET (덧셈 결과를 달라)
 * - HTTP Path : /add
 * - 쿼리 : 2개 숫자 number1, number2
 * - 결과 : 덧셈 결과
 */

// @ 문법 : 자바의 어노테이션
  // 어노테이션 - 마법같은 일을 해준다고...
@RestController // 이 클래스를 API의 진입 지점으로 만들어준다.
public class CalculatorController {

  // GetMapping은 아래 함수를 GET API로 만듭니다.
  // 그런데 path를 /add로 설정합니다.
  @GetMapping("/add")
  public int addTwoNumbers(
      @RequestParam int number1, // 파라미터 이름과 같은 쿼리를 찾아 넣어준다.
      @RequestParam int number2
  ) {
    return number1 + number2;
  }

  // 자바에 익숙하지 않다면, (당연하겠지만) 자바로 서버 만들기 힘들다~
  @GetMapping("/minus")
  public double minusTwoNumbers(@RequestParam double num1, @RequestParam double num2) {
    return num1 - num2;
  }

  // 이 어노테이션은 아래 함수를 POST method를 받게 해줍니다!
  // POST 같은 경우는 "클래스"로 데이터를 받아야 합니다. (Body를 쓰니까!)
  @PostMapping("/multiply")
  public int multiplyTwoNumbers(
      @RequestBody MultiplyRequest request
  ) {
    return request.getNumber1() * request.getNumber2();
  }

}
