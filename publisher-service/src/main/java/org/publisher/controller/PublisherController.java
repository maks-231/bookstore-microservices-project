package org.publisher.controller;

import jakarta.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.publisher.dto.PublisherDto;
import org.publisher.entity.Publisher;
import org.publisher.repository.PublisherRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/publisher")
@CrossOrigin(originPatterns = "*", maxAge = 3600)
public class PublisherController {
  @Resource
  ModelMapper modelMapper;

  @Resource
  private PublisherRepository publisherRepository;

  @GetMapping
  public List<PublisherDto> getAllPublishers() {
    List<Publisher> publishers = publisherRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    List<PublisherDto> publisherDtos = modelMapper.map(publishers, new TypeToken<List<PublisherDto>>() {}.getType());
    return publisherDtos;
  }

  @PostMapping
  public void createNewPublisher(@RequestBody PublisherDto publisherDto) {
    Publisher publisher = modelMapper.map(publisherDto, Publisher.class);
    publisherRepository.save(publisher);
  }

  @PutMapping
  public void updatePublisher(@RequestParam Long id, @RequestParam String name) throws Exception {
    Optional<Publisher> publisherOptional = publisherRepository.findById(id);
    if(publisherOptional.isPresent()) {
      Publisher publisher = publisherOptional.get();
      publisher.setName(name);
      publisherRepository.save(publisher);
    } else {
      throw new Exception("There is no such publisher");
    }
  }

  @DeleteMapping("/{id}")
  public void deletePublisherById(@PathVariable Long id) {
    publisherRepository.deleteById(id);
  }

  @GetMapping("/{id}")
  public PublisherDto getPublisherById(@PathVariable Long id) throws Exception {
    Optional<Publisher> publisherOptional = publisherRepository.findById(id);
    if(publisherOptional.isPresent()) {
      Publisher publisher = publisherOptional.get();
      PublisherDto publisherDto = modelMapper.map(publisher, PublisherDto.class);
      return publisherDto;
    } else {
      throw new Exception("There is no such publisher");
    }
  }
}
