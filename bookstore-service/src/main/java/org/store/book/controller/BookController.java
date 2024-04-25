package org.store.book.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.store.book.model.Book;
import org.store.book.repository.BookRepository;

import java.util.List;

import jakarta.annotation.Resource;

/**
 * @author ibodnar@amsoft-group.com
 */

@RestController
@RequestMapping("/book")
public class BookController {

  @Resource
  private BookRepository bookRepository;

  @GetMapping
  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }
}
