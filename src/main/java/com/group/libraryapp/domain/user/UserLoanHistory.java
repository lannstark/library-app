package com.group.libraryapp.domain.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 지난 시간 간단 요약
 * - 트랜잭션 : 주문을 하면, 포인트도 저장되고 결제기록도 남고 주문 기록도 남아야해요.
 * 하다가 문제가 생기면, 이 3가지 저장은 한 몸처럼 모두 성공 or 모두 실패
 * -> 트랜잭션 : 쪼갤 수 없는 업무의 최소 단위
 * - @Transactional (간단 ㅎㅎ)
 * <p>
 * - 영속성 컨텍스트 : 되게 어려운 개념. 아 이런게 있구나~ @Transactional과 한 몸처럼...
 * 1. 변경 감지 (Entity 객체의 값을 변경하고, 직접 save 하지 않아도 알아서 저장해주는 기능)
 * 2. 쓰기 지연 (만약 트랜잭션 안에서 여러번 insert/update/delete를 한다면 모아서 해주는 기능)
 * 3. 1차 캐싱 (id로 가져온 데이터를 임시 저장하는 기능)
 * <p>
 * JavaScript -> API를 호출하고 API를 결과를 사용하는 법 (같이 코딩 ㅎㅎ)
 */
// 트랜잭션, 영속성 컨텍스트
// 실제 책 관련 기능들도 만들기 시작!

// 내일은 나머지 기능 다 만들거에요~~
// jquery --> API 통신 클라이언트 AP 를 사용하고, API 결과를 제어

// 일요일 --> 예제 동물병원 키오스크 화면을 아주 멋없게 만드는거 보여드리고...
// 도서 관리 서비스 여러분만의 화면 만드는 시간을 쭉~~ 가지면서 클라이언트 코딩

// 우리는 지금 "A라는 책을 누군가 빌려갔는지" 확인
// bookName = "A" 이고 is_return = false이면, A라는 책을 반납하지 않은 기록 = A가 대출중
@Entity
public class UserLoanHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id = null;
  private long userId;
  private String bookName;
  private boolean isReturn;

  public UserLoanHistory() {

  }

  public UserLoanHistory(long userId, String bookName, boolean isReturn) {
    this.userId = userId;
    this.bookName = bookName;
    this.isReturn = isReturn;
  }

  public void doReturn() {
    isReturn = true;
  }

}
