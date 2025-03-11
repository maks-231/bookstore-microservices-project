package org.store.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.store.book.model.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

  List<Book> findAllByGenreId(long genreId);

  Book findBookByIsbn(String isbn);

  void deleteBookByIsbn(String isbn);
}
