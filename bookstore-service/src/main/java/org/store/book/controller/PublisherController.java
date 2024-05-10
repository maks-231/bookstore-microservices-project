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
import org.store.book.model.Publisher;
import org.store.book.repository.PublisherRepository;

import java.util.List;

import jakarta.annotation.Resource;

/**
 * @author ibodnar@amsoft-group.com
 */

@RestController
@RequestMapping("/publisher")
@CrossOrigin(originPatterns = "*", maxAge = 3600)
public class PublisherController {

  @Resource
  private PublisherRepository publisherRepository;

  @GetMapping
  public List<Publisher> getAllPublishers() {
    return publisherRepository.findAll();
  }

  @PostMapping
  public void createNewPublisher(@RequestBody Publisher publisher) {
    publisherRepository.save(publisher);
  }

  @PutMapping
  public void updatePublisher(@RequestBody Publisher publisher) {
    publisherRepository.save(publisher);
  }

  @DeleteMapping("/{id}")
  public void deletePublisherById(@PathVariable long id) {
    publisherRepository.deleteById(id);
  }
}
