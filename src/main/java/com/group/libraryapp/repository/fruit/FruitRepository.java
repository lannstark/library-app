package com.group.libraryapp.repository.fruit;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FruitRepository {

  private final JdbcTemplate jdbcTemplate;

  public FruitRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  // 실수를 인지하는 시점이 느린 경우 - 코드가 동작해서 실제 기능이 쓰일 때 확인!!
  // 실수를 인지하는 시점이 빠른 경우도 있나요?! - 코드가 동작하기 전에 실행 할려고 하면 에러가 발생!!
  // 빨리 알 수록 좋다!!
  public void saveFruit(String name, int price, String date) {
    String sql = "INSERT INTO fruit (name, price, due_date) VALUES (?, ?, ?)";
    jdbcTemplate.update(sql, name, price, date);
  }

}

