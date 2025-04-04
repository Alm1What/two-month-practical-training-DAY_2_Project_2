package org.example.day_2_practice_project_two.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "borrow_record")
public class BorrowRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookId;
    private String user_name;
    private LocalDateTime borrow_date;
    private LocalDateTime return_date;


}
