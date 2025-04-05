package org.example.day_2_practice_project_two.repository;

import org.example.day_2_practice_project_two.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
