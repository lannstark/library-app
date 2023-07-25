package com.group.libraryapp.domain.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id = null;
  private String name;

  public Book() {

  }

  public Book(String name) {
    this.name = name;
  }

}
