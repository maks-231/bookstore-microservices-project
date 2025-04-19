package org.store.book.dto;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BookDto implements Serializable {
    private String isbn;
    private String title;
    private String description;
    private GenreDto genre;
    private PublisherDto publisher;
    private LocalDate publicationDate;
    private String language;
    private int pages;
    private Float price;
    private ImageDto image;
    private Long genreId;
    private Long publisherId;
    private List<AuthorDto> authors;
    private List<Long> authorsIds;
}
