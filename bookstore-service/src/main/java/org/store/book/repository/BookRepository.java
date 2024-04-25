package org.store.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.store.book.model.Book;

/**
 * @author ibodnar@amsoft-group.com
 */

public interface BookRepository extends JpaRepository<Book, Long> {
}
