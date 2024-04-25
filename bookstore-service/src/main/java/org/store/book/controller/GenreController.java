package org.store.book.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.store.book.model.Genre;
import org.store.book.repository.GenreRepository;

import java.util.List;

import jakarta.annotation.Resource;

/**
 * @author ibodnar@amsoft-group.com
 */

@RestController
@RequestMapping("/genre")
public class GenreController {

  @Resource
  private GenreRepository genreRepository;

  @GetMapping
  public List<Genre> getAllGenres() {
    return genreRepository.findAll();
  }
}
