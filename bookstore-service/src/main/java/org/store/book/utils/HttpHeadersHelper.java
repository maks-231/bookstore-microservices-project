package org.store.book.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Collections;

public class HttpHeadersHelper {
    public static HttpHeaders getApplicationJsonHeaders() {
        HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
