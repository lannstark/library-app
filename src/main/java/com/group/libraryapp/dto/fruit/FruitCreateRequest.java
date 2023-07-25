package com.group.libraryapp.dto.fruit;

public class FruitCreateRequest {

  private String name;
  private int price;
  private String date;

  public FruitCreateRequest(String name, int price, String date) {
    this.name = name;
    this.price = price;
    this.date = date;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  public String getDate() {
    return date;
  }
}
