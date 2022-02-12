package com.example.AndroidAPIServer.controller;


import com.example.AndroidAPIServer.domain.entity.PostDriver;
import com.example.AndroidAPIServer.domain.entity.PostPassenger;
import com.example.AndroidAPIServer.dto.post.PostDriverDto;
import com.example.AndroidAPIServer.dto.post.PostPassengerDto;
import com.example.AndroidAPIServer.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/post")
public class PostController {
    private final PostService postService;

    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping("/passenger/register")
    public ResponseEntity<String> registerPassenger(@RequestBody PostPassengerDto dto){
        String message = postService.savePassengerPost(dto);
        return ResponseEntity.ok(message);
    }   //태워주세요 게시글 저장

    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping("/driver/register")
    public ResponseEntity<String> registerDriver(@RequestBody PostDriverDto dto){
        String message = postService.saveDriverPost(dto);
        return ResponseEntity.ok(message);
    } //타세요 게시글 저장

    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/passenger/getPost")
    public List<PostPassenger> getPassengerPost(){
        return postService.getPassengerPost();
    }   //태워주세요 게시글 조회

    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/driver/getPost")
    public List<PostDriver> getDriverPost(){
        return postService.getDriverPost();
    }   //타세요 게시글 조회


}
