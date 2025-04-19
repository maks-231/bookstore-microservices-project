package org.store.book.service;

import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.store.book.dto.AuthorDto;
import org.store.book.utils.HttpHeadersHelper;

import java.util.List;

@Service
@Log4j2
public class AuthorService {
    @Resource
    private RestTemplate restTemplate;

    @Value("${AUTHOR.HOST}")
    private String host;

    @Value("${AUTHOR.PORT}")
    private String port;

    public List<AuthorDto> findAll() {
        String urlToAuthor = new StringBuilder("http://").append(host).append(":")
                .append(port).append("/author").toString();
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(urlToAuthor, Object.class);
        return (List<AuthorDto>) responseEntity.getBody();
    }

    public void updateAuthor(AuthorDto authorDto) {
        HttpEntity<?> entity = new HttpEntity<>(HttpHeadersHelper.getApplicationJsonHeaders());

        MultiValueMap<String, String> requestParameters = new LinkedMultiValueMap<>();
        requestParameters.add("id", authorDto.getId().toString());
        requestParameters.add("name", authorDto.getName());
        requestParameters.add("email", authorDto.getEmail());
        String urlToAuthor = new StringBuilder("http://").append(host).append(":")
                .append(port).append("/author").toString();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlToAuthor).queryParams(requestParameters);
        restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.PUT, entity, AuthorDto.class);
    }

    public void createNewAuthor(AuthorDto authorDto) {
        String urlToAuthor = new StringBuilder("http://").append(host).append(":")
                .append(port).append("/author").toString();
        restTemplate.exchange(urlToAuthor, HttpMethod.POST,
                new HttpEntity<>(authorDto, HttpHeadersHelper.getApplicationJsonHeaders()), AuthorDto.class);
    }

    public void deleteAuthorById(Long id) {
        String urlToAuthor = new StringBuilder("http://").append(host).append(":")
                .append(port).append("/author").toString();
        restTemplate.delete(urlToAuthor + "/" + id);
    }

    public AuthorDto getAuthorById(Long id) {
        String urlToAuthor = new StringBuilder("http://").append(host).append(":")
                .append(port).append("/author").toString();
        ResponseEntity<AuthorDto> responseEntity =  restTemplate.getForEntity(urlToAuthor + "/" + id, AuthorDto.class);
        return responseEntity.getBody();
    }
}
