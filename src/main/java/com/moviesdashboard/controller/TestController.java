package com.moviesdashboard.controller;

import org.springframework.web.bind.annotation.RestController;

import com.moviesdashboard.dtos.MovieDto;
import com.moviesdashboard.execption.ApiResponse;
import com.moviesdashboard.service.OmdbApiService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag( name  = "Test Controller")
@SecurityRequirement(name = "Authorization")
public class TestController {

    private final OmdbApiService omdbApiService;

    @GetMapping("/path")
    public String getMethodName(@RequestParam String param) {
        return new String("Hi From Server");
    }

    @GetMapping("/movie")
    public ApiResponse<MovieDto> getMovieByTitle(@RequestParam String movieTitle) {
        return ApiResponse.ok(omdbApiService.getMovieByTitle(movieTitle));
    }
    
    
}
