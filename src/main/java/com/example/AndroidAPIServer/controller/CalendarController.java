package com.example.AndroidAPIServer.controller;


import com.example.AndroidAPIServer.dto.calendar.CalendarPostDto;
import com.example.AndroidAPIServer.dto.chat.ReservedPostDto;
import com.example.AndroidAPIServer.dto.post.PostDto;
import com.example.AndroidAPIServer.dto.post.UserPostDto;
import com.example.AndroidAPIServer.dto.user.AndroidLocalUserDto;
import com.example.AndroidAPIServer.service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/calendar")
public class CalendarController {

    private final CalendarService calendarService;

    //user가 작성하거나 진행중인 post정보 load
    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping("/post")
    public List<ReservedPostDto> getUserPostData(@RequestBody AndroidLocalUserDto androidLocalUserDto){
        return calendarService.getCalendarPostData(androidLocalUserDto);
    }   //타세요 게시글 조회

    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping("/detail")
    public PostDto getUserPostData(@RequestBody ReservedPostDto reservedPostDto){

        return calendarService.getPostDtoById(reservedPostDto);
    }   //postDetail조회
}