package org.example.day_2_practice_project_two.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Long authorId;
    private boolean isBorrowed;

    @ManyToOne(fetch = FetchType.LAZY) // тут може бути проблемка що не всі дані будуть відображатися (але не факт не пам'ятаю що саме)
    @JoinColumn(name = "author_id")
    private Author author;

    public Book() {
    }

    public Book(Long id, String title, Long authorId, boolean isBorrowed, Author author) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.isBorrowed = isBorrowed;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
