package com.example.CustomConsume;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GreetingService {
    private static final String API_URL = "https://anime-quotes1.p.rapidapi.com/api/random";
    @Value("${rapidapi.key}")
    private static final String RAPIDAPI_KEY = "a0d7d31be8msha21dde42356eca7p12aa9ajsn46c46ae1d442";
    @Value("${rapidapi.host}")
    private static final String RAPIDAPI_HOST = "anime-quotes1.p.rapidapi.com";

    public AnimeQuote getAnimeQuote(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", RAPIDAPI_KEY);
        headers.set("X-RapidAPI-Host", RAPIDAPI_HOST);
        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.GET, entity, String.class);

        ObjectMapper mapper = new ObjectMapper();
        AnimeQuote quote = null;
        try {
            quote = mapper.readValue(response.getBody(), AnimeQuote.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return quote;
    }
}
