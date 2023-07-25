package com.group.libraryapp.domain.hospital;

public class AnimalCardCreateRequest {
  private String name;
  private int age;
  private String type;
  private String symptom;

  public AnimalCardCreateRequest(String name, int age, String type, String symptom) {
    this.name = name;
    this.age = age;
    this.type = type;
    this.symptom = symptom;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getType() {
    return type;
  }

  public String getSymptom() {
    return symptom;
  }
}
