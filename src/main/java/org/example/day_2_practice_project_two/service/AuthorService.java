package org.example.day_2_practice_project_two.service;

import org.example.day_2_practice_project_two.dto.AuthorDTO;
import org.example.day_2_practice_project_two.entity.Author;
import org.example.day_2_practice_project_two.mapper.AuthorMapper;
import org.example.day_2_practice_project_two.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;
    private AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository,
                         AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }


    public AuthorDTO create(AuthorDTO authorDTO) {
        Author author = authorMapper.toEntity(authorDTO);
        author = authorRepository.save(author);
        return authorMapper.toDto(author);
    }

    public AuthorDTO findById(Long bookId) {
        Author author = authorRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        return authorMapper.toDto(author);
    }

    public List<AuthorDTO> findAll() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorDTO> authorDTOS = new ArrayList<>();
        for (Author author : authors) {
            authorDTOS.add(authorMapper.toDto(author));
        }
        return authorDTOS;
    }

    public AuthorDTO update(AuthorDTO authorDTO, Long authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("Author not found"));
        author.setName(authorDTO.getName());
        author.setCountry(authorDTO.getCountry()); // це скоріше за все в mapper можна додати і не робити самому set()
        author = authorRepository.save(author);
        return authorMapper.toDto(author);
    }

    public AuthorDTO delete(Long authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("Author not found"));
        authorRepository.delete(author);
        return authorMapper.toDto(author);
    }


}
