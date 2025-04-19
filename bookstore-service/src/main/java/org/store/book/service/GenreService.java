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
import org.store.book.utils.HttpHeadersHelper;

import java.util.List;

@Service
public class GenreService {
    @Resource
    private RestTemplate restTemplate;

    @Value("${GENRE.HOST}")
    private String host;

    @Value("${GENRE.PORT}")
    private String port;

    public List<GenreDto> getAllGenres() {
        String urlToGenre = new StringBuilder("http://").append(host).append(":")
                .append(port).append("/genre").toString();
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(urlToGenre, Object.class);
        return (List<GenreDto>) responseEntity.getBody();
    }

    public void createNewGenre(GenreDto genreDto) {
        String urlToGenre = new StringBuilder("http://").append(host).append(":")
                .append(port).append("/genre").toString();
        restTemplate.exchange(urlToGenre, HttpMethod.POST,
                new HttpEntity<>(genreDto, HttpHeadersHelper.getApplicationJsonHeaders()), GenreDto.class);
    }

    public void updateGenre(GenreDto genreDto) {
        HttpEntity<?> entity = new HttpEntity<>(HttpHeadersHelper.getApplicationJsonHeaders());

        MultiValueMap<String, String> requestParameters = new LinkedMultiValueMap<>();
        requestParameters.add("id", genreDto.getId().toString());
        requestParameters.add("name", genreDto.getName());

        String urlToGenre = new StringBuilder("http://").append(host).append(":")
                .append(port).append("/genre").toString();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlToGenre).queryParams(requestParameters);
        restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.PUT, entity, GenreDto.class);
    }

    public void deleteGenreById(long id) {
        String urlToGenre = new StringBuilder("http://").append(host).append(":")
                .append(port).append("/genre").toString();
        restTemplate.delete(urlToGenre+ "/" + id);
    }

    public GenreDto getGenreById(long id) {
        String urlToGenre = new StringBuilder("http://").append(host).append(":")
                .append(port).append("/genre").toString();
        ResponseEntity<GenreDto> responseEntity = restTemplate.getForEntity(urlToGenre + "/" + id, GenreDto.class);
        return responseEntity.getBody();
    }
}
