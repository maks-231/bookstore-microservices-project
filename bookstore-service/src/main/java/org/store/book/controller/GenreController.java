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
import org.store.book.dto.GenreDto;
import org.store.book.service.GenreService;

@RestController
@RequestMapping("/genre")
@CrossOrigin(originPatterns = "*", maxAge = 3600)
public class GenreController {
  @Resource
  private GenreService genreService;

  @GetMapping
  public List<GenreDto> getAllGenres() {
    return genreService.getAllGenres();
  }

  @PostMapping
  public void createNewGenre(@RequestBody GenreDto genre) {
    genreService.createNewGenre(genre);
  }

  @PutMapping
  public void updateGenre(@RequestBody GenreDto genre) {
    genreService.updateGenre(genre);
  }

  @DeleteMapping("/{id}")
  public void deleteGenreById(@PathVariable long id) {
    genreService.deleteGenreById(id);
  }
}
