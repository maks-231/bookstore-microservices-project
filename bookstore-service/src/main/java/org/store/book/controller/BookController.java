package org.store.book.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.store.book.dto.BookDto;

import java.util.List;

import jakarta.annotation.Resource;
import org.store.book.service.BookService;

@RestController
@RequestMapping("/book")
@CrossOrigin(originPatterns = "*", maxAge = 3600)
public class BookController {
  @Resource
  private BookService bookService;

  @GetMapping
  public List<BookDto> getAllBooks() {
    return bookService.getAllBooks();
  }

  @GetMapping("/genre/{genreId}")
  public List<BookDto> getAllBooksByGenre(@PathVariable Long genreId) {
    return bookService.getAllBooksByGenre(genreId);
  }

  @GetMapping("/{isbn}")
  public BookDto getBookByIsbn(@PathVariable String isbn) {
    return bookService.getBookByIsbn(isbn);
  }

  @PostMapping
  public void submitBook(@RequestBody BookDto book) {
    bookService.submitBook(book);
  }

  @DeleteMapping("/{isbn}")
  public void deleteBookByIsbn(@PathVariable String isbn) {
    bookService.deleteBookByIsbn(isbn);
  } 
}
