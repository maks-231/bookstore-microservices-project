package org.author.controller;

import jakarta.annotation.Resource;
import org.author.entity.Author;
import org.author.dto.AuthorDto;
import org.author.repository.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
@CrossOrigin(originPatterns = "*", maxAge = 3600)
public class AuthorController {
  @Autowired
  private ModelMapper modelMapper;

  @Resource
  private AuthorRepository authorRepository;

  @GetMapping
  public List<AuthorDto> getAllAuthors() {
    List<Author> authors = authorRepository.findAll();
    return modelMapper.map(authors, new TypeToken<List<AuthorDto>>() {}.getType());
  }

  @PostMapping
  public void createNewAuthor(@RequestBody AuthorDto authorDto) {
    Author author = modelMapper.map(authorDto, Author.class);
    authorRepository.save(author);
  }

  @PutMapping
  public void updateAuthor(@RequestParam Long id, @RequestParam String name, @RequestParam String email) throws Exception {
    Optional<Author> authorOptional = authorRepository.findById(id);
    if(authorOptional.isPresent()) {
      Author author = authorOptional.get();
      author.setName(name);
      author.setEmail(email);
      authorRepository.save(author);
    } else {
      throw new Exception("There is no such author");
    }
  }

  @DeleteMapping("/{id}")
  public void deleteAuthorById(@PathVariable Long id) {
    authorRepository.deleteById(id);
  }

  @GetMapping("/{id}")
  public AuthorDto getAuthorById(@PathVariable Long id) throws Exception {
    Optional<Author> genreOptional = authorRepository.findById(id);
    if(genreOptional.isPresent()) {
      Author genre = genreOptional.get();
      AuthorDto authorDto = modelMapper.map(genre, AuthorDto.class);
      return authorDto;
    } else {
      throw new Exception("There is no such genre");
    }
  }
}
