package org.example.day_2_practice_project_two.controller;

import org.example.day_2_practice_project_two.dto.AuthorDTO;
import org.example.day_2_practice_project_two.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping()
    public ResponseEntity<AuthorDTO> addAuthor(@RequestBody AuthorDTO authorDTO) {
        return ResponseEntity.ok(authorService.create(authorDTO));
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Long authorId) {
        return ResponseEntity.ok(authorService.findById(authorId));
    }

    @GetMapping()
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
        return ResponseEntity.ok(authorService.findAll());
    }

    @DeleteMapping("/{authorId}")
    public ResponseEntity<AuthorDTO> deleteAuthorById(@PathVariable Long authorId) {
        return ResponseEntity.ok(authorService.delete(authorId));
    }

    @PutMapping("/{authorId}")
    public ResponseEntity<AuthorDTO> updateAuthor(@RequestBody AuthorDTO authorDTO, @PathVariable Long authorId) {
        return ResponseEntity.ok(authorService.update(authorDTO, authorId));
    }
}
