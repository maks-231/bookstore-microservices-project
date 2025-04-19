package org.book.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "books_to_authors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookToAuthors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "book_isbn")
    private String isbn;

    @Column(name = "author_id")
    private Long authorId;
}
