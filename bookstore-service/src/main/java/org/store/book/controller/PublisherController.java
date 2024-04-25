package org.store.book.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.store.book.model.Publisher;
import org.store.book.repository.PublisherRepository;

import java.util.List;

import jakarta.annotation.Resource;

/**
 * @author ibodnar@amsoft-group.com
 */

@RestController
@RequestMapping("/publisher")
public class PublisherController {
  
  @Resource
  private PublisherRepository publisherRepository;
  
  @GetMapping
  public List<Publisher> getAllPublishers() {
    return publisherRepository.findAll();
  }
}
