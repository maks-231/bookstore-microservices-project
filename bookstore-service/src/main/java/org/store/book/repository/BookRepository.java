package org.store.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.store.book.model.Book;

import java.util.List;

/**
 * @author ibodnar@amsoft-group.com
 */

public interface BookRepository extends JpaRepository<Book, Long> {

  List<Book> findAllByGenre_Id(long genreId);

  Book findBookByIsbn(String isbn);

  void deleteBookByIsbn(String isbn);

}
