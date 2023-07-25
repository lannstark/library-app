package com.group.libraryapp.domain.user;

import javax.persistence.*;

// 아니~~ SQL을 안쓴다는게 무슨 말이여?!!
// 1. 문자열이라 우리가 오타.... 실제 실행해서 버그가 생겨야만 인지
// 2. 특정 DB에 종속적이게 된다.
// 3. SQL이란 것과 객체란 것의 패러다임이 다르다
  // 객체는 양방향, 상속
  // SQL(테이블) 단방향, 상속 X
// 4. 반복작업이 많았죠. CRUD

// ---> JPA : 자바 진영에서 데이터를 영구적으로 보관하기 위한 약속
//      (= ORM) : 객체와 테이블을 매핑해주는 기술

// 여기에 이제 JPA를 적용할겁니다!
// 이 객체랑 우리가 만들었던 user 테이블이랑 "매핑"을 할거에요!
// 참고 Entity 단어의 뜻 : 저장되고 관리되어야 하는 데이터
@Entity // 마법 - 이 객체는 JPA를 적용한 객체야~
public class User {

  // 0으로 구분이 애매할 수 있으니 아예 확실히 null
  @Id // primary key라는 뜻!
  // 이 값은 자동 생성                      auto_increment
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id = null;

  private String name;
  private Integer age;

  // JPA는 적용하려면 @Entity 클래스에 "기본 생성자"가 필수!
  public User() {

  }

  public User(String name, Integer age) {
    if (name.isBlank()) {
      throw new RuntimeException("사람의 이름이 어떻게 비어 있나~");
    }
    this.name = name;
    this.age = age;
  }

  public void updateName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public Long getId() {
    return id;
  }
}
