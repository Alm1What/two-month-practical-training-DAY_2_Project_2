package org.example.day_2_practice_project_two.mapper;

import org.example.day_2_practice_project_two.entity.BorrowRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BorrowRecordMapper {
    @Mapping(source = "book.id", target = "bookId")
    @Mapping(source = "book.title", target = "bookTitle")
    BorrowRecordMapper toDto(BorrowRecord record);

    @Mapping(source = "bookId", target = "book.id")
    BorrowRecord toEntity(BorrowRecordMapper dto);
}
