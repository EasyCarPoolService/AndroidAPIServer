package com.example.AndroidAPIServer.controller;


import com.example.AndroidAPIServer.dto.chat.ChatMessageDto;
import com.example.AndroidAPIServer.dto.chat.RoomDto;
import com.example.AndroidAPIServer.dto.post.PostDto;
import com.example.AndroidAPIServer.dto.user.AndroidLocalUserDto;
import com.example.AndroidAPIServer.service.ChatService;
import com.example.AndroidAPIServer.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/chat")
public class StompRoomController {


    private final ChatService chatService;
    private final PostService postService;

    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping("/createroom")
    public RoomDto createRoom(@RequestBody RoomDto roomDto){

        System.out.println(roomDto.getPostType());

        roomDto.setRoomId(chatService.createRoomDto(roomDto));

        return roomDto;
    }

    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping("/getAllRoom")
    public List<RoomDto> getAllRoom(@RequestBody AndroidLocalUserDto userDto){

        return chatService.findAllRooms(userDto.getEmail());
    }
    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping("/findMessageByRoomId")
    public List<ChatMessageDto> enterRoom(@RequestBody RoomDto roomDto){
        return chatService.findMessageByRoomId(roomDto.getRoomId());
    }


    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping("/findPostInfo")
    public PostDto findPostInfo(@RequestBody RoomDto roomDto){
        return postService.findPostById(roomDto);
    }


    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping("/leaveChatRoom")
    public ResponseEntity<String> leaveChatRoom(@RequestBody RoomDto roomDto){
        chatService.leaveChatRoom(roomDto);
        return ResponseEntity.ok("success");
    }   //return succes -> transaction동작 여부에 따라 리턴하도록 수정!





}

