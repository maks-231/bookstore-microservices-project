package org.book.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
  @Id
  @Column(name = "isbn")
  private String isbn;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "genre_id")
  private Long genreId;

  @Column(name = "publisher_id")
  private Long publisherId;

  @Column(name = "publication_date")
  private LocalDate publicationDate;

  @Column(name = "language")
  private String language;

  @Column(name = "pages")
  private int pages;

  @Column(name = "price")
  private Float price;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinColumn(name = "image_id")
  private Image image;
}
