package org.example.day_2_practice_project_two.mapper;

import org.example.day_2_practice_project_two.dto.AuthorDTO;
import org.example.day_2_practice_project_two.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDTO toDto(Author author);
    Author toEntity(AuthorDTO dto);
}
