package com.example.AndroidAPIServer.controller;


import com.example.AndroidAPIServer.domain.entity.PostDriver;
import com.example.AndroidAPIServer.domain.entity.PostPassenger;
import com.example.AndroidAPIServer.dto.post.*;
import com.example.AndroidAPIServer.dto.user.AndroidLocalUserDto;
import com.example.AndroidAPIServer.service.PostService;
import com.google.gson.annotations.SerializedName;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;



/*
작성한 태워주세요/타세요/진행중 현황 정보 로드하기
 */


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
    @PostMapping("/passenger/getPost")
    public List<PostDto> getPassengerPost(@RequestBody int currentPage){
        System.out.println("currentPage : " + currentPage);
        return postService.getPassengerPost(currentPage);
    }   //태워주세요 게시글 조회

    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping("/driver/getPost")
    public List<PostDto> getDriverPost(@RequestBody int currentPage){
        return postService.getDriverPost(currentPage);
    }   //타세요 게시글 조회

    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping("/user/getPost")
    public List<PostDto> getDriverPost(@RequestBody AndroidLocalUserDto androidLocalUserDto){
        return postService.getUserPost(androidLocalUserDto);
    }   //타세요 게시글 조회


    //User의 작성 게시글 혹은 진행중 게시글 조회
    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping("/getUserPostData")
    public UserPostDto getUserPostData(@RequestBody AndroidLocalUserDto androidLocalUserDto){

        return postService.getUserPostData(androidLocalUserDto);
    }   //타세요 게시글 조회

    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping("/getPostByDistrict")
    public List<PostDto> getPostByDistrict(@RequestBody PostDistrictDto postDistrictDto){
        return postService.getPostByDistrict(postDistrictDto);
    }   //타세요 게시글 조회

    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping("/progressToComplete")
    public ResponseEntity<String> progressToComplete(@RequestBody PostReviewDto dto){
        postService.progressToComplete(dto);
        return ResponseEntity.ok("success");
    }   //진행중 -> 완료처리 (후기 저장)

}
