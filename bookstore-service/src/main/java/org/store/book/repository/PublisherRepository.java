package org.store.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.store.book.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
