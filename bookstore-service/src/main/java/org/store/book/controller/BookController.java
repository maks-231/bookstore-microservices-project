package org.store.book.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.store.book.model.Book;
import org.store.book.repository.BookRepository;

import java.util.List;

import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;

/**
 * @author ibodnar@amsoft-group.com
 */

@RestController
@RequestMapping("/book")
@CrossOrigin(originPatterns = "*", maxAge = 3600)
public class BookController {

  @Resource
  private BookRepository bookRepository;

  @GetMapping
  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  @GetMapping("/genre/{genreId}")
  public List<Book> getAllBooksByGenre(@PathVariable Long genreId) {
    return bookRepository.findAllByGenre_Id(genreId);
  }

  @GetMapping("/{isbn}")
  public Book getBookByIsbn(@PathVariable String isbn) {
    return bookRepository.findBookByIsbn(isbn);
  }

  @PostMapping
  public void submitBook(@RequestBody Book book) {
    bookRepository.save(book);
  }

  @Transactional
  @DeleteMapping("/{isbn}")
  public void deleteBookByIsbn(@PathVariable String isbn) {
    bookRepository.deleteBookByIsbn(isbn);
  } 
}
