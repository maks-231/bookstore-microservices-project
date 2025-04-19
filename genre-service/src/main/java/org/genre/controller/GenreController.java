package org.genre.controller;

import jakarta.annotation.Resource;
import org.genre.dto.GenreDto;
import org.genre.entity.Genre;
import org.genre.repository.GenreRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genre")
@CrossOrigin(originPatterns = "*", maxAge = 3600)
public class GenreController {
  @Autowired
  private ModelMapper modelMapper;

  @Resource
  private GenreRepository genreRepository;

  @GetMapping
  public List<GenreDto> getAllGenres() {
    List<Genre> genres = genreRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    List<GenreDto> authorDtos = modelMapper.map(genres, new TypeToken<List<GenreDto>>() {}.getType());
    return authorDtos;
  }

  @PostMapping
  public void createNewGenre(@RequestBody GenreDto genreDto) {
    Genre genre = modelMapper.map(genreDto, Genre.class);
    genreRepository.save(genre);
  }

  @PutMapping
  public void updateGenre(@RequestParam Long id, @RequestParam String name) throws Exception {
    Optional<Genre> genreOptional = genreRepository.findById(id);
    if(genreOptional.isPresent()) {
      Genre genre = genreOptional.get();
      genre.setName(name);
      genreRepository.save(genre);
    } else {
      throw new Exception("There is no such genre");
    }
  }

  @DeleteMapping("/{id}")
  public void deleteGenreById(@PathVariable Long id) {
    genreRepository.deleteById(id);
  }

  @GetMapping("/{id}")
  public GenreDto getGenreById(@PathVariable Long id) throws Exception {
    Optional<Genre> genreOptional = genreRepository.findById(id);
    if(genreOptional.isPresent()) {
      Genre genre = genreOptional.get();
      GenreDto genreDto = modelMapper.map(genre, GenreDto.class);
      return genreDto;
    } else {
      throw new Exception("There is no such genre");
    }
  }
}
