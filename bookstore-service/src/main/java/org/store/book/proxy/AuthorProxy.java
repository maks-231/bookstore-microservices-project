package org.store.book.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.store.book.dto.AuthorDto;

import java.util.List;

@FeignClient(name="author-service")
public interface AuthorProxy {
    @GetMapping("/author")
    List<AuthorDto> getAllAuthors();
}
