package org.example.day_2_practice_project_two.dto;

public class CreateBookRequest {
    private BookDTO book;
    private AuthorDTO author;

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}
