package com.moviesdashboard.dtos;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MovieDto {

    @JsonProperty("Title")
    private String title;
    @JsonProperty("Year")
    private String year;
    @JsonProperty("Rated")
    private String rated;
    @JsonProperty("Released")
    private Date released;
    @JsonProperty("Runtime")
    private String runtime;
    @JsonProperty("Plot")
    private String plot;
    @JsonProperty("Language")
    private String language;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("Awards")
    private String awards;
    @JsonProperty("Poster")  
    private String posterUrl;
    @JsonProperty("Merascore")
    private Integer metascore;
    @JsonProperty("ImdbRating")
    private Double imdbRating;
    @JsonProperty("ImdbVotes")
    private String imdbVotes;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("DVD")
    private Date dvdRelease;
    @JsonProperty("BoxOffice")
    private String boxOffice;
    @JsonProperty("Production")
    private String production;
    @JsonProperty("Website")
    private String website;
    @JsonProperty("Actor")
    private ActorDto actorDto;
    @JsonProperty("Ratings")
    private RatingDto ratingDto;
    @JsonProperty("Genre")
    private GenreDto genreDto;
}
