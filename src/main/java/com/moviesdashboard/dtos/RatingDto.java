package com.moviesdashboard.dtos;

import java.util.List;

import lombok.Data;

@Data
public class RatingDto {
    private List<RatingResponse> ratings;
}
