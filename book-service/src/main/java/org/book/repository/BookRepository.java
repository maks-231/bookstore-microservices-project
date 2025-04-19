package org.book.repository;


import org.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

  List<Book> findAllByGenreId(long genreId);

  Book findBookByIsbn(String isbn);

  void deleteBookByIsbn(String isbn);
}
