package com.group;

public class Main {

  // [1] 트랜잭션이란 것을 시작! -> start transaction;
  //   [2] 데이터를 넣거나 (포인트, 결제, 주문) 지우거나 업데이트 하거나 자유롭게!
  //       필요한 insert, update, delete를 알아서~
  //
  // [3-1] 2번 과정에서 문제가 생겼으면 모두다 폐기 -> rollback;
  // [3-2] 문제가 없으면 모두다 통과! -> commit;

  // 문제... 만약에 c()를 호출했는데 에러가 발생하면 어떻게 될까요?!
  // throw new RuntimeException();
  // c()를 호출하다가 에러가 나면, A랑 B는 잘 되고 C는 안되요!

  // b()를 호출했는데 에러가 발생하면 어떻게 될까요?!
  // A가 나오고 B랑 C는 안나와요! = A만 나온다
  public static void main(String[] args) {
    a();
    b();
    c();
  }

  public static void a() {
    System.out.println("A");
  }

  public static void b() {
    System.out.println("B");
  }

  public static void c() {
    throw new RuntimeException();
    // System.out.println("C");
  }
}
