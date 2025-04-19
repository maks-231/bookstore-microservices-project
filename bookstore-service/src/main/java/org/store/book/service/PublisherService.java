package org.store.book.service;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.store.book.dto.GenreDto;
import org.store.book.dto.PublisherDto;
import org.store.book.utils.HttpHeadersHelper;

import java.util.List;

@Service
public class PublisherService {
    @Resource
    private RestTemplate restTemplate;

    @Value("${PUBLISHER.HOST}")
    private String host;

    @Value("${PUBLISHER.PORT}")
    private String port;

    public List<PublisherDto> getAllPublishers() {
        String urlToPublisher= new StringBuilder("http://").append(host).append(":")
                .append(port).append("/publisher").toString();
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(urlToPublisher, Object.class);
        return (List<PublisherDto>) responseEntity.getBody();
    }

    public void createNewPublisher(PublisherDto publisherDto) {
        String urlToPublisher= new StringBuilder("http://").append(host).append(":")
                .append(port).append("/publisher").toString();
        restTemplate.exchange(urlToPublisher, HttpMethod.POST,
                new HttpEntity<>(publisherDto, HttpHeadersHelper.getApplicationJsonHeaders()), PublisherDto.class);
    }

    public void updatePublisher(PublisherDto publisherDto) {
        HttpEntity<?> entity = new HttpEntity<>(HttpHeadersHelper.getApplicationJsonHeaders());

        MultiValueMap<String, String> requestParameters = new LinkedMultiValueMap<>();
        requestParameters.add("id", publisherDto.getId().toString());
        requestParameters.add("name", publisherDto.getName());
        String urlToPublisher= new StringBuilder("http://").append(host).append(":")
                .append(port).append("/publisher").toString();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlToPublisher).queryParams(requestParameters);
        restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.PUT, entity, PublisherDto.class);
    }

    public void deletePublisherById(Long id) {
        String urlToPublisher= new StringBuilder("http://").append(host).append(":")
                .append(port).append("/publisher").toString();
        restTemplate.delete(urlToPublisher + "/" + id);
    }

    public PublisherDto getPublisherById (Long id) {
        String urlToPublisher= new StringBuilder("http://").append(host).append(":")
                .append(port).append("/publisher").toString();
        ResponseEntity<PublisherDto> responseEntity = restTemplate.getForEntity(urlToPublisher + "/" + id, PublisherDto.class);
        return responseEntity.getBody();
    }
}
