package org.store.book.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import jakarta.annotation.Resource;
import org.store.book.dto.AuthorDto;
import org.store.book.service.AuthorService;

@RestController
@RequestMapping("/author")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthorController {
  @Resource
  private AuthorService authorService;

  @GetMapping
  public List<AuthorDto> getAllAuthors() {
    return authorService.findAll();
  }

  @PostMapping
  public void createNewAuthor(@RequestBody AuthorDto author) {
    authorService.createNewAuthor(author);
  }

  @PutMapping
  public void updateAuthor(@RequestBody AuthorDto author) {
    authorService.updateAuthor(author);
  }

  @DeleteMapping("/{id}")
  public void deleteAuthorById(@PathVariable Long id) {
    authorService.deleteAuthorById(id);
  }
}
