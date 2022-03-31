package com.example.AndroidAPIServer.controller;

import com.example.AndroidAPIServer.dto.chat.ChatMessageDto;
import com.example.AndroidAPIServer.dto.chat.ReservedPostDto;
import com.example.AndroidAPIServer.dto.location.LocationDto;
import com.example.AndroidAPIServer.dto.user.AndroidLocalUserDto;
import com.example.AndroidAPIServer.service.CalendarService;
import com.example.AndroidAPIServer.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LocationController {

    private final CalendarService calendarService;
    private final LocationService locationService;


    //user가 작성하거나 진행중인 post정보 load
    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping("/api/location/getReservedPost")
    public List<ReservedPostDto> getUserPostData(@RequestBody AndroidLocalUserDto androidLocalUserDto) {
        System.out.println(androidLocalUserDto.getEmail());
        return calendarService.getCalendarPostData(androidLocalUserDto);
    }   //타세요 게시글 조회

    @MessageMapping(value = "/location/stomp")
    public void sendLocation(LocationDto locationDto){
        locationService.sendLocation(locationDto);
    }//sendLocation



}