package com.example.CustomConsume;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AnimeQuote(String anime, String character, String quote) {
}
