package com.moviesdashboard.mapper;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.moviesdashboard.dtos.MovieApiResponse;
import com.moviesdashboard.dtos.MovieDto;
import com.moviesdashboard.dtos.RatingResponse;
import com.moviesdashboard.dtos.RatingDto;
import com.moviesdashboard.model.Movie;


@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MovieMapper extends BaseMapper<Object , MovieDto ,Movie>{

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    @Mapping(source = "title", target = "title") // Should match the getter
    @Mapping(source = "year", target = "year")
    @Mapping(source = "rated", target = "rated")
    @Mapping(source = "released", target = "released", dateFormat = "dd MMM yyyy")
    @Mapping(source = "runtime", target = "runtime")
    @Mapping(source = "plot", target = "plot")
    @Mapping(source = "language", target = "language")
    @Mapping(source = "country", target = "country")
    @Mapping(source = "awards", target = "awards")
    @Mapping(source = "poster", target = "posterUrl")
    @Mapping(source = "metascore", target = "metascore", defaultValue = "0")
    @Mapping(source = "imdbRating", target = "imdbRating")
    @Mapping(source = "imdbVotes", target = "imdbVotes")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "dvd", target = "dvdRelease", dateFormat = "dd MMM yyyy" , qualifiedByName = "mapDVD")
    @Mapping(source = "boxOffice", target = "boxOffice")
    @Mapping(source = "production", target = "production")
    @Mapping(source = "website", target = "website")
    @Mapping(source = "actors", target = "actorDto.actors", qualifiedByName = "mapActors")
    @Mapping(source = "ratings", target = "ratingDto", qualifiedByName = "mapRatings")
    @Mapping(source = "genre", target = "genreDto.genres", qualifiedByName = "mapGenres")
    MovieDto toMovieDto(MovieApiResponse response);

    // Custom mapping functions for complex fields
    @Named("mapActors")
    default List<String> mapActors(String actors) {
        return Arrays.asList(actors.split(", "));
    }

    @Named("mapGenres")
    default List<String> mapGenres(String genres) {
        return Arrays.asList(genres.split(", "));
    }

    @Named("mapRatings")
    default RatingDto mapRatings(List<RatingResponse> ratings) {
        if (ratings != null && !ratings.isEmpty()) {
            RatingDto dto = new RatingDto();
            dto.setRatings(ratings);
            return dto;
        }
        return null;
    }

    @Named("mapDVD")
    default Date mapDVD(String dvd) {
        if ("N/A".equals(dvd)) {
            return null; // or return a default Date if needed
        }
        try {
            return new SimpleDateFormat("dd MMM yyyy").parse(dvd);
        } catch (ParseException e) {
            // Handle the exception as needed, perhaps log it
            return null; // Return null or some default value in case of error
        }
    }
}
