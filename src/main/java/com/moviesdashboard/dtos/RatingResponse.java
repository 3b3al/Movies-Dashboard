package com.moviesdashboard.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RatingResponse {

     @JsonProperty("Source")
        private String source;

        @JsonProperty("Value")
        private String value;
}
