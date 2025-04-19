package org.store.book.service;

import jakarta.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.store.book.dto.AuthorDto;
import org.store.book.dto.BookDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Resource
    private ModelMapper modelMapper;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private GenreService genreService;

    @Resource
    private PublisherService publisherService;

    @Resource
    private AuthorService authorService;

    @Value("${BOOK.HOST}")
    private String host;

    @Value("${BOOK.PORT}")
    private String port;

    public List<BookDto> getAllBooks() {
        String urlToBook = new StringBuilder("http://").append(host).append(":")
                .append(port).append("/book").toString();
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(urlToBook, Object.class);
        List<BookDto> bookDtos  = modelMapper.map(responseEntity.getBody(), new TypeToken<List<BookDto>>() {}.getType());
        bookDtos.forEach(bookDto -> {
            bookDto.setGenre(genreService.getGenreById(bookDto.getGenreId()));
            bookDto.setPublisher(publisherService.getPublisherById(bookDto.getPublisherId()));
            bookDto.setAuthors(getBookAuthorsByIsbn(bookDto.getIsbn()));
        });
        return bookDtos;
    }

    public List<BookDto> getAllBooksByGenre(Long genreId) {
        String urlToBook = new StringBuilder("http://").append(host).append(":")
                .append(port).append("/book").toString();
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(urlToBook +"/genre/" + genreId, Object.class);
        return (List<BookDto>) responseEntity.getBody();
    }

    public BookDto getBookByIsbn(String isbn) {
        String urlToBook = new StringBuilder("http://").append(host).append(":")
                .append(port).append("/book").toString();
        ResponseEntity<BookDto> responseEntity = restTemplate.getForEntity(urlToBook + "/" + isbn, BookDto.class);
        BookDto bookDto = responseEntity.getBody();
        if(bookDto != null) {
            bookDto.setAuthors(getBookAuthorsByIsbn(bookDto.getIsbn()));
            bookDto.setPublisher(publisherService.getPublisherById(bookDto.getPublisherId()));
            bookDto.setGenre(genreService.getGenreById(bookDto.getGenreId()));
        }
        return bookDto;
    }

    public void submitBook(BookDto bookDto) {
        String urlToBook = new StringBuilder("http://").append(host).append(":")
                .append(port).append("/book").toString();
        bookDto.setAuthorsIds(bookDto.getAuthors().stream().map(AuthorDto::getId).collect(Collectors.toList()));
        bookDto.setPublisherId(bookDto.getPublisher().getId());
        bookDto.setGenreId(bookDto.getGenre().getId());
        restTemplate.postForEntity(urlToBook, bookDto, BookDto.class);
    }

    public void deleteBookByIsbn(String isbn) {
        String urlToBook = new StringBuilder("http://").append(host).append(":")
                .append(port).append("/book").toString();
        restTemplate.delete(urlToBook +"/" + isbn);
    }

    public List<AuthorDto> getBookAuthorsByIsbn(String isbn) {
        String urlToBook = new StringBuilder("http://").append(host).append(":")
                .append(port).append("/book").toString();
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(urlToBook+ "/" + isbn + "/authorsIds", Object.class);
        List<Long> authorsIds  = modelMapper.map(responseEntity.getBody(), new TypeToken<List<Long>>() {}.getType());
        List<AuthorDto> authorDtos = new ArrayList<>();
        authorsIds.forEach( authorId -> authorDtos.add(authorService.getAuthorById(authorId)));
        return authorDtos;
    }
}
