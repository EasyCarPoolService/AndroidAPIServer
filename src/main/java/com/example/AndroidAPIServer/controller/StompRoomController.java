package com.example.AndroidAPIServer.controller;


import com.example.AndroidAPIServer.dto.chat.RoomDto;
import com.example.AndroidAPIServer.dto.user.AndroidLocalUserDto;
import com.example.AndroidAPIServer.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/chat")
public class StompRoomController {

    private final ChatService chatService;

    @PostMapping("/createroom")
    public RoomDto createRoom(@RequestBody RoomDto roomDto){
        roomDto.setRoomId(chatService.createRoomDto(roomDto));
        return roomDto;
    }

    @PostMapping("/getAllRoom")
    public List<RoomDto> getAllRoom(@RequestBody AndroidLocalUserDto userDto){

        return chatService.findAllRooms(userDto.getEmail());
    }

}

