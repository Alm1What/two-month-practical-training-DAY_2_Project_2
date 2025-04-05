package org.example.day_2_practice_project_two.controller;

import org.example.day_2_practice_project_two.dto.AuthorDTO;
import org.example.day_2_practice_project_two.dto.BookChangeAuthorRequest;
import org.example.day_2_practice_project_two.dto.BookDTO;
import org.example.day_2_practice_project_two.dto.CreateBookRequest;
import org.example.day_2_practice_project_two.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping()
    public ResponseEntity<BookDTO> createBook(@RequestBody CreateBookRequest request) {
        return ResponseEntity.ok(bookService.createBook(request));
    }

    @GetMapping()
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<List<BookDTO>> getAllBooksByAuthorId(@PathVariable Long authorId) {
        return ResponseEntity.ok(bookService.getAllBooksByAuthorId(authorId));
    }

    @GetMapping("/get-book-by-id/{bookId}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long bookId) {
        return ResponseEntity.ok(bookService.getBookById(bookId));
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<BookDTO> deleteBookById(@PathVariable Long bookId) {
        return ResponseEntity.ok(bookService.deleteBookById(bookId));
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<BookDTO> updateBook(@RequestBody BookDTO bookDTO, @PathVariable Long bookId) {
        return ResponseEntity.ok(bookService.updateBook(bookDTO, bookId));
    }


    @PutMapping("/change-author")
    public ResponseEntity<BookDTO> changeAuthor(@RequestBody BookChangeAuthorRequest request) {
        return ResponseEntity.ok(bookService.changeAuthor(request));
    }

}
