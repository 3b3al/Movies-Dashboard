package com.moviesdashboard.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RegisterUserDto {
    private String email;

    @JsonProperty("user_name")
    private String userName;
    
    private String password;
    
    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;



}
