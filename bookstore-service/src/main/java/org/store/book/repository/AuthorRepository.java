package org.store.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.store.book.model.Author;


public interface AuthorRepository extends JpaRepository<Author, Long> {
}
