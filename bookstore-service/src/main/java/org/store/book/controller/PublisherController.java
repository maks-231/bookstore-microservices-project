package org.store.book.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import jakarta.annotation.Resource;
import org.store.book.dto.PublisherDto;
import org.store.book.service.PublisherService;

@RestController
@RequestMapping("/publisher")
@CrossOrigin(originPatterns = "*", maxAge = 3600)
public class PublisherController {
  @Resource
  private PublisherService publisherService;

  @GetMapping
  public List<PublisherDto> getAllPublishers() {
    return publisherService.getAllPublishers();
  }

  @PostMapping
  public void createNewPublisher(@RequestBody PublisherDto publisherDto) {
    publisherService.createNewPublisher(publisherDto);
  }

  @PutMapping
  public void updatePublisher(@RequestBody PublisherDto publisherDto) {
    publisherService.updatePublisher(publisherDto);
  }

  @DeleteMapping("/{id}")
  public void deletePublisherById(@PathVariable long id) {
    publisherService.deletePublisherById(id);
  }
}
