package org.store.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.store.book.model.Author;

/**
 * @author ibodnar@amsoft-group.com
 */

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
