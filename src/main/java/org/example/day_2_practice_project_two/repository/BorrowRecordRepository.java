package org.example.day_2_practice_project_two.repository;

import org.example.day_2_practice_project_two.entity.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
}
