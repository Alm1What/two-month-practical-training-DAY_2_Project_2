package org.example.day_2_practice_project_two.mapper;

import org.example.day_2_practice_project_two.dto.BookDTO;
import org.example.day_2_practice_project_two.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(source = "author.id", target = "authorId")
    @Mapping(source = "author.name", target = "authorName")
    BookDTO toDto(Book book);

    @Mapping(source = "authorId", target = "author.id") // прив'язка по ID
    Book toEntity(BookDTO dto);
}
