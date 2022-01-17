package com.example.AndroidAPIServer.controller;


import com.example.AndroidAPIServer.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/post")
public class PostController {
    private PostService postService;

    @PostMapping("/passenger/register")




}
