package com.moviesdashboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviesdashboard.dtos.MovieApiResponse;
import com.moviesdashboard.dtos.MovieDto;
import com.moviesdashboard.mapper.MovieMapper;
import com.moviesdashboard.service.OmdbApiService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OmdbApiServiceImpl implements OmdbApiService{

    @Value("${omdb.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    private final MovieMapper movieMapper;


    public MovieDto getMovieByTitle (String movieTitle){
        try {
            String url = String.format("http://www.omdbapi.com/?apikey=%s&t=%s", apiKey, movieTitle);
            String jsonResponse = restTemplate.getForObject(url, String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            MovieApiResponse apiResponse = objectMapper.readValue(jsonResponse , MovieApiResponse.class);
    
            // Map the response to the DTO
            return movieMapper.toMovieDto(apiResponse);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        
    }
}
