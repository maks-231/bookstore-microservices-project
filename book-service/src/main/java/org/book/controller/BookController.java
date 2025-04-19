package org.book.controller;

import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.book.dto.BookDto;
import org.book.entity.Book;
import org.book.entity.BookToAuthors;
import org.book.repository.BookRepository;
import org.book.repository.BookToAuthorsRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin(originPatterns = "*", maxAge = 3600)
public class BookController {
  @Resource
  ModelMapper modelMapper;

  @Resource
  private BookRepository bookRepository;

  @Resource
  private BookToAuthorsRepository bookToAuthorsRepository;

  @GetMapping
  public List<BookDto> getAllBooks() {
    List<Book> books = bookRepository.findAll();
    return modelMapper.map(books, new TypeToken<List<BookDto>>() {}.getType());
  }

  @GetMapping("/genre/{genreId}")
  public List<BookDto> getAllBooksByGenre(@PathVariable Long genreId) {
    List<Book> books = bookRepository.findAllByGenreId(genreId);
    return modelMapper.map(books, new TypeToken<List<BookDto>>() {}.getType());
  }

  @GetMapping("/{isbn}")
  public BookDto getBookByIsbn(@PathVariable String isbn) {
    Book book = bookRepository.findBookByIsbn(isbn);
    return modelMapper.map(book, BookDto.class);
  }

  @GetMapping("/{isbn}/authorsIds")
  public List<Long> getBookAuthorsByIsbn(@PathVariable String isbn) {
    List<BookToAuthors> bookToAuthors = bookToAuthorsRepository.findAllByIsbn(isbn);
    List<Long> authorsIds = new ArrayList<>();
    bookToAuthors.forEach(bookToAuthor -> authorsIds.add(bookToAuthor.getAuthorId()));
    return authorsIds;
  }

  @GetMapping("/{authorId}/isbns")
  public List<String> getBookIsbnsByAuthorId(@PathVariable Long authorId) {
    List<BookToAuthors> bookToAuthors = bookToAuthorsRepository.findAllByAuthorId(authorId);
    List<String> isbns = new ArrayList<>();
    bookToAuthors.forEach(bookToAuthor -> isbns.add(bookToAuthor.getIsbn()));
    return isbns;
  }

  @PostMapping
  public void submitBook(@RequestBody BookDto bookDto) {
    Book book = modelMapper.map(bookDto, Book.class);
    String isbn = bookDto.getIsbn();
    List<Long> authorsIds = bookDto.getAuthorsIds();

    bookRepository.save(book);

    List<BookToAuthors> bookToAuthors = bookToAuthorsRepository.findAllByIsbn(isbn);
    bookToAuthors.forEach(bookToAuthor -> {
      if(!authorsIds.contains(bookToAuthor.getAuthorId())){
        bookToAuthorsRepository.delete(bookToAuthor);
      }
    });

    List<BookToAuthors> bookToAuthors1 = bookToAuthorsRepository.findAllByIsbn(isbn);
      authorsIds.forEach(authorsId -> {
        Long alreadySaved =
                bookToAuthors1.stream()
                        .map(BookToAuthors::getAuthorId)
                        .filter(id -> id.equals(authorsId))
                        .findFirst().orElse(null);

        if (alreadySaved == null) {
          bookToAuthorsRepository.save(BookToAuthors.builder().isbn(isbn).authorId(authorsId).build());
        }
      });
  }

  @Transactional
  @DeleteMapping("/{isbn}")
  public void deleteBookByIsbn(@PathVariable String isbn) {
    bookRepository.deleteBookByIsbn(isbn);
  } 
}
