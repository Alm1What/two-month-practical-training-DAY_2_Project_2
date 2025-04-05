package org.example.day_2_practice_project_two.repository;

import org.example.day_2_practice_project_two.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
