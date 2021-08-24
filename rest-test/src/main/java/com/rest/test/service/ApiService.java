package com.rest.test.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiService {
    private final RestTemplate restTemplate;

    public HashMap<String, Object> getData() {
        final String URL = "https://s3.ap-northeast-2.amazonaws.com/bunjang-interview/events.json";
        HttpHeaders headers = new HttpHeaders();
        headers.add("accept", MediaType.APPLICATION_JSON_VALUE);

        ResponseEntity<ArrayList> resultMap = restTemplate.exchange(URL, HttpMethod.GET, new HttpEntity<>(headers), ArrayList.class);
        HashMap<String, Object> result = new HashMap<>();
        result.put("statusCode", resultMap.getStatusCode());
        result.put("headers", resultMap.getHeaders());
        result.put("body", resultMap.getBody());

        return result;
    }
}
