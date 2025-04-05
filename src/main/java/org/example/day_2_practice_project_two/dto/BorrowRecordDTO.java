package org.example.day_2_practice_project_two.dto;

import java.time.LocalDate;

public class BorrowRecordDTO {

    private Long id;
    private Long bookId;
    private String bookTitle;

    private String userName;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public BorrowRecordDTO() {
    }

    public BorrowRecordDTO(Long id, Long bookId, String bookTitle, String userName, LocalDate borrowDate, LocalDate returnDate) {
        this.id = id;
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.userName = userName;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
