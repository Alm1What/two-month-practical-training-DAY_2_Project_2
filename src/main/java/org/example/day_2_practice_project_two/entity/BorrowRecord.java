package org.example.day_2_practice_project_two.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "borrow_record")
public class BorrowRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookId;
    private String user_name;
    private LocalDate borrow_date;
    private LocalDate return_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

}
