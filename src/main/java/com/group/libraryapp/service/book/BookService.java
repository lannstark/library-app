package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.book.BookRepository;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserLoanHistory;
import com.group.libraryapp.domain.user.UserLoanHistoryRepository;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.book.BookCreateRequest;
import com.group.libraryapp.dto.book.BookLoanRequest;
import com.group.libraryapp.dto.book.BookReturnRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

  private final BookRepository bookRepository;
  private final UserRepository userRepository;
  private final UserLoanHistoryRepository userLoanHistoryRepository;

  public BookService(
      BookRepository bookRepository,
      UserRepository userRepository,
      UserLoanHistoryRepository userLoanHistoryRepository
  ) {
    this.bookRepository = bookRepository;
    this.userRepository = userRepository;
    this.userLoanHistoryRepository = userLoanHistoryRepository;
  }

  @Transactional
  public void createNewBook(BookCreateRequest request) {
    Book book = new Book(request.getName());
    bookRepository.save(book);
  }

  // 1. 들어오는 책 이름으로 책을 찾아요.
  // 2. 들어오는 유저 이름으로 유저를 찾아요.
  // 3-1. 혹시 지금 빌리려는 책을 다른 사람이 빌린건 아닌지 확인해서 빌렸다면 예외
  // 3-2. 빌릴 수 있는 책이면, UserLoanHistory 테이블에 데이터를 쌓아서, "대출 처리"를 해주겠습니다.
  @Transactional
  public void loanBook(BookLoanRequest request) {
    // 1. 책 찾기
    Book book = bookRepository.findByName(request.getBookName());
    if (book == null) {
      throw new IllegalArgumentException();
    }

    // 2. 유저 찾기
    User user = userRepository.findByName(request.getUserName());
    if (user == null) {
      throw new IllegalArgumentException();
    }

    // 3-1. 대출중인 책이면 예외
    if (userLoanHistoryRepository.existsByBookNameAndIsReturn(request.getBookName(), false)) {
      throw new IllegalArgumentException();
    }

    // 3-2. 대출 처리
    UserLoanHistory history = new UserLoanHistory(user.getId(), request.getBookName(), false);
    userLoanHistoryRepository.save(history);
  }

  // 1. 들어오는 책을 찾는다. O
  // 2. 들어오는 유저를 찾는다. O
  // 3. 해당하는 대출 기록을 찾는다.
  // 4. 대출 기록의 is_return을 true로 바꿔준다.
  @Transactional
  public void returnBook(BookReturnRequest request) {
    // 1. 책 찾기
    Book book = bookRepository.findByName(request.getBookName());
    if (book == null) {
      throw new IllegalArgumentException();
    }

    // 2. 유저 찾기
    User user = userRepository.findByName(request.getUserName());
    if (user == null) {
      throw new IllegalArgumentException();
    }

    // 3. 대출 기록 찾기
    UserLoanHistory history = userLoanHistoryRepository
        .findByUserIdAndBookName(user.getId(), request.getBookName());
    if (history == null) {
      throw new IllegalArgumentException();
    }

    // is_return -> true (반납처리)
    history.doReturn();
    // userLoanHistoryRepository.save(history);
  }

}
