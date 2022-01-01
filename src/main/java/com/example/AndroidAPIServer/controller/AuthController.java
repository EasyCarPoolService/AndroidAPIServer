package com.example.AndroidAPIServer.controller;


import com.example.AndroidAPIServer.dto.user.AndroidLocalUserDto;
import com.example.AndroidAPIServer.dto.user.LoginDto;
import com.example.AndroidAPIServer.dto.user.TokenDto;
import com.example.AndroidAPIServer.jwt.JwtFilter;
import com.example.AndroidAPIServer.jwt.TokenProvider;
import com.example.AndroidAPIServer.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    @PostMapping("/authenticate")
    public ResponseEntity<AndroidLocalUserDto> authorize(@Valid @RequestBody LoginDto loginDto) {

        return userService.login(loginDto);
    }
}