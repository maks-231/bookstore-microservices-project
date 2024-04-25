package org.store.book.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.store.book.model.Author;
import org.store.book.repository.AuthorRepository;

import java.util.List;

import jakarta.annotation.Resource;

/**
 * @author ibodnar@amsoft-group.com
 */

@RestController
@RequestMapping("/author")
public class AuthorController {
  
  @Resource
  private AuthorRepository authorRepository;
  
  @GetMapping
  public List<Author> getAllAuthors() {
    return authorRepository.findAll();
  }
}
