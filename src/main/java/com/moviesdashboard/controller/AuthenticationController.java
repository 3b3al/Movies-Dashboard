package com.moviesdashboard.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviesdashboard.dtos.LoginUserDto;
import com.moviesdashboard.dtos.RegisterUserDto;
import com.moviesdashboard.execption.ApiResponse;
import com.moviesdashboard.model.User;
import com.moviesdashboard.shared.AuthenticationService;
import com.moviesdashboard.shared.JwtService;
import com.moviesdashboard.shared.LoginResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RequestMapping("/auth")
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag( name  = "Authentication Controller")
public class AuthenticationController {
 private final JwtService jwtService;
    
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ApiResponse<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ApiResponse.created(registeredUser);
    }

    @PostMapping("/login")
    public ApiResponse<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse().builder()
        .token(jwtToken)
        .expiresIn(jwtService.getExpirationTime())
        .build();

        return ApiResponse.ok(loginResponse);
    }
}
