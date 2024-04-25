package org.store.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.store.book.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
