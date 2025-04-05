package org.example.day_2_practice_project_two.service;

import jakarta.transaction.Transactional;
import org.example.day_2_practice_project_two.dto.AuthorDTO;
import org.example.day_2_practice_project_two.dto.BookChangeAuthorRequest;
import org.example.day_2_practice_project_two.dto.BookDTO;
import org.example.day_2_practice_project_two.dto.CreateBookRequest;
import org.example.day_2_practice_project_two.entity.Author;
import org.example.day_2_practice_project_two.entity.Book;
import org.example.day_2_practice_project_two.mapper.BookMapper;
import org.example.day_2_practice_project_two.repository.AuthorRepository;
import org.example.day_2_practice_project_two.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository bookRepository;
    private BookMapper bookMapper;
    private AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, BookMapper bookMapper, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.authorRepository = authorRepository;
    }
    @Transactional
    public BookDTO createBook(CreateBookRequest request) {
        AuthorDTO authorDTO = request.getAuthor();
        BookDTO bookDTO = request.getBook();

        Author author = authorRepository.findByName(authorDTO.getName())
                .orElseGet(() -> {
                    Author newAuthor = new Author();
                    newAuthor.setName(authorDTO.getName());
                    newAuthor.setCountry(authorDTO.getCountry());
                    return authorRepository.save(newAuthor);
                });

        Book book = bookMapper.toEntity(bookDTO);
        book.setAuthor(author); // 🔥 Тепер є зв'язок
        book = bookRepository.save(book);

        return bookMapper.toDto(book);
    }


    public BookDTO getBookById(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        return bookMapper.toDto(book);
    }

    @Transactional
    public BookDTO updateBook(BookDTO bookDTO, Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        book.setTitle(bookDTO.getTitle());
        book.setBorrowed(bookDTO.isBorrowed());

        if (bookDTO.getAuthorId() != null) {
            Author author = authorRepository.findById(bookDTO.getAuthorId())
                    .orElseThrow(() -> new RuntimeException("Author not found"));
            book.setAuthor(author);
        } else if(bookDTO.getAuthorName() != null) {
            Author author = authorRepository.findByName(bookDTO.getAuthorName())
                    .orElseThrow(() -> new RuntimeException("Author not found"));
            book.setAuthor(author);
        }
        book = bookRepository.save(book);
        return bookMapper.toDto(book);
        /* Хороший варіант додати спосіб перевірки не повного рядку а по частинам типу якщо користувач знає
        лише частину імені автора (але тоді тут може виникнути проблема що буде декілька авторів з одним іменем тому ту краще подумати)
        */
    }

    @Transactional
    public BookDTO deleteBookById(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        bookRepository.delete(book);
        return bookMapper.toDto(book);
    }

    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(bookMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public BookDTO changeAuthor(BookChangeAuthorRequest request) {
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        AuthorDTO authorDTO = request.getAuthor();

        Author author = authorRepository.findByName(authorDTO.getName())
                .map(existingAuthor -> {
                    // оновлюємо наявного
                    existingAuthor.setCountry(authorDTO.getCountry());
                    return authorRepository.save(existingAuthor);
                })
                .orElseGet(() -> {
                    // створюємо нового
                    Author newAuthor = new Author();
                    newAuthor.setName(authorDTO.getName());
                    newAuthor.setCountry(authorDTO.getCountry());
                    return authorRepository.save(newAuthor);
                });

        book.setAuthor(author);
        bookRepository.save(book);

        return bookMapper.toDto(book);
    }


    public List<BookDTO> getAllBooksByAuthorId(Long authorId) {
        authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("Author not found"));
        return bookRepository.findByAuthorId(authorId).stream().map(bookMapper::toDto).collect(Collectors.toList());
    }




}
