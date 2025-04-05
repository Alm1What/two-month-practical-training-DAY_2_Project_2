package org.example.day_2_practice_project_two.controller;

import org.example.day_2_practice_project_two.dto.BorrowRecordDTO;
import org.example.day_2_practice_project_two.entity.BorrowRecord;
import org.example.day_2_practice_project_two.service.BorrowRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow-record")
public class BorrowRecordController {

    private BorrowRecordService borrowRecordService;

    public BorrowRecordController(BorrowRecordService borrowRecordService) {
        this.borrowRecordService = borrowRecordService;
    }

    @PostMapping()
    public ResponseEntity<BorrowRecordDTO> save(@RequestBody BorrowRecordDTO borrowRecordDTO) {
        return ResponseEntity.ok(borrowRecordService.create(borrowRecordDTO));
    }

    @GetMapping()
    public ResponseEntity<List<BorrowRecordDTO>> findAll() {
        return ResponseEntity.ok(borrowRecordService.findAll());
    }

    @GetMapping("/id/{recordId}")
    public ResponseEntity<BorrowRecordDTO> findById(@PathVariable Long recordId) {
        return ResponseEntity.ok(borrowRecordService.findById(recordId));
    }

    @GetMapping("/{userName}")
    public ResponseEntity<BorrowRecordDTO> findByUserName(@PathVariable String userName) {
        return ResponseEntity.ok(borrowRecordService.findByUserName(userName));
    }

    @DeleteMapping("/{deletedId}")
    public ResponseEntity<BorrowRecordDTO> deleteById(@PathVariable Long deletedId) {
        return ResponseEntity.ok(borrowRecordService.deleteById(deletedId));
    }

    @PutMapping("/{recordId}")
    public ResponseEntity<BorrowRecordDTO> update(@RequestBody BorrowRecordDTO borrowRecordDTO, @PathVariable Long recordId) {
        return ResponseEntity.ok(borrowRecordService.update(borrowRecordDTO, recordId));
    }

}
