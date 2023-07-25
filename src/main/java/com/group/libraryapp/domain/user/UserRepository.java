package com.group.libraryapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// Spring Data JPA : 스프링과 JPA를 함께 쉽게 쓰게 도와주는 친구
// JPA : 원천기술
public interface UserRepository extends JpaRepository<User, Long> {

  // 함수의 윗부분(시그니처)만 작성하면...
  // select * from user where name = ?;
  // 있으면 User 주고요 없으면 null 줘요~
  User findByName(String name);

  // select * from user where age >= ?;
  List<User> findAllByAgeGreaterThanEqual(Integer age);

  boolean existsByName(String name);

  List<User> findAllByAge(Integer age);

  long countByAge(Integer age);

  // Optional이 무엇인가?!
  // Java에서 가장 많이 개발자가 실수를 하는 부분 중 하나 -> null 관리
  // Java 창시자 중 한 명.. null을 Java에 도입한 건 실수였다 ㅠㅠㅠ
  // 수십억 달러의 손실이 있었다...

  // 이런 생각 -->
  // 음.... 아예 확실하게 null이 될 수 있는 객체랑
  // null이 될 수 없는 객체를 분리
  // Optional이란걸 만들어서
  // Optional<User> -> 이 안에 User가 있는데 null일 수 있어!
  // Java 8버전!

}
