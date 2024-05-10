package org.store.book.model;


import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author ibodnar@amsoft-group.com
 */
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

  @ManyToOne
  @JoinColumn(name = "genre_id")
  private Genre genre;

  @ManyToOne
  @JoinColumn(name = "publisher_id")
  private Publisher publisher;

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

  @ManyToMany
  @JoinTable(name = "books_to_authors",
      joinColumns = @JoinColumn(name = "book_isbn", referencedColumnName = "isbn"),
      inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
  private List<Author> authors;
}
