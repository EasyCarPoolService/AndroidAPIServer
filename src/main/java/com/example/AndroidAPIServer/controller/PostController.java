package com.example.AndroidAPIServer.controller;


import com.example.AndroidAPIServer.domain.entity.PostPassenger;
import com.example.AndroidAPIServer.dto.post.PostPassengerDto;
import com.example.AndroidAPIServer.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/post")
public class PostController {
    private final PostService postService;

    @PostMapping("/passenger/register")
    public ResponseEntity<String> registerPassenger(@RequestBody PostPassengerDto dto){
        String message = postService.savePassengerPost(dto);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/passenger/getPost")
    public List<PostPassenger> getPassengerPost(){
        return postService.getPassengerPost();
    }







}
