package com.group.libraryapp.dto.book;

/**
 * RequestBody에 사용할 JSON을 받는 DTO의 경우에 사실은 생성자가 필요하지 않음!
 * 지금 보신 것처럼 필드가 하나 있는데 생성자가 있으면 오히려 에러가 납니다...
 */
public class BookCreateRequest {

  private String name;

  public String getName() {
    return name;
  }

}
