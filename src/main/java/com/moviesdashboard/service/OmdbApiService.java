package com.moviesdashboard.service;

import com.moviesdashboard.dtos.MovieDto;

public interface OmdbApiService {
    public MovieDto getMovieByTitle (String movieTitle);
}
