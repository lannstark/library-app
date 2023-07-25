package com.group.libraryapp.domain.hospital;

public class AnimalCardResponse {
  private long id;

  private String name;
  private int age;
  private String type;
  private String symptom;

  public AnimalCardResponse(AnimalCard ac) {
    this.id = ac.getId();
    this.name = ac.getName();
    this.age = ac.getAge();
    this.type = ac.getType();
    this.symptom = ac.getSymptom();
  }
}
