package org.example.day_2_practice_project_two.dto;

public class BookChangeAuthorRequest {

    private Long bookId;
    private AuthorDTO author;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}
