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
}
