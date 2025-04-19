package org.book.repository;

import org.book.entity.BookToAuthors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookToAuthorsRepository extends JpaRepository<BookToAuthors, Long> {
    List<BookToAuthors> findAllByIsbn(String isbn);
    List<BookToAuthors> findAllByAuthorId(Long authorId);
    void deleteBookByIsbn(String isbn);
}
