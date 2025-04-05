package org.example.day_2_practice_project_two.service;

import jakarta.transaction.Transactional;
import org.example.day_2_practice_project_two.dto.BorrowRecordDTO;
import org.example.day_2_practice_project_two.entity.BorrowRecord;
import org.example.day_2_practice_project_two.mapper.BorrowRecordMapper;
import org.example.day_2_practice_project_two.repository.BorrowRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BorrowRecordService {


    private BorrowRecordRepository borrowRecordRepository;
    private BorrowRecordMapper borrowRecordMapper;

    public BorrowRecordService(BorrowRecordRepository borrowRecordRepository, BorrowRecordMapper borrowRecordMapper) {
        this.borrowRecordRepository = borrowRecordRepository;
        this.borrowRecordMapper = borrowRecordMapper;
    }

    @Transactional
    public BorrowRecordDTO create(BorrowRecordDTO borrowRecordDTO) {
        BorrowRecord borrowRecord = borrowRecordMapper.toEntity(borrowRecordDTO);
        borrowRecord = borrowRecordRepository.save(borrowRecord);
        return borrowRecordMapper.toDto(borrowRecord);
    }

    public BorrowRecordDTO findById(Long id) {
        BorrowRecord borrowRecord = borrowRecordRepository.findById(id).orElse(null);
        return borrowRecordMapper.toDto(borrowRecord);
    }

    @Transactional
    public BorrowRecordDTO update(BorrowRecordDTO borrowRecordDTO, Long recordId) {
        BorrowRecord borrowRecord = borrowRecordRepository.findById(recordId).orElse(null);
        borrowRecord.setUserName(borrowRecordDTO.getUserName());
        borrowRecord.setBorrowDate(borrowRecordDTO.getBorrowDate());
        borrowRecord.setReturnDate(borrowRecordDTO.getReturnDate());
        borrowRecord = borrowRecordRepository.save(borrowRecord);
        return borrowRecordMapper.toDto(borrowRecord);
    }

    public List<BorrowRecordDTO> findAll() {
        return borrowRecordRepository.findAll().stream().map(borrowRecordMapper::toDto).collect(Collectors.toList());
    }

    public BorrowRecordDTO findByUserName(String userName) {
        BorrowRecord borrowRecord = borrowRecordRepository.findByUserName(userName);
        return borrowRecord != null ? borrowRecordMapper.toDto(borrowRecord) : null;
    }


    @Transactional
    public BorrowRecordDTO deleteById(Long id) {
        BorrowRecord borrowRecord = borrowRecordRepository.findById(id).orElse(null);
        borrowRecordRepository.delete(borrowRecord);
        return borrowRecordMapper.toDto(borrowRecord);
    }
}
