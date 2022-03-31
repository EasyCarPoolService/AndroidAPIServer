package com.example.AndroidAPIServer.controller;


import com.example.AndroidAPIServer.dto.chat.ChatMessageDto;
import com.example.AndroidAPIServer.dto.chat.ReservedPostDto;
import com.example.AndroidAPIServer.dto.chat.RoomDto;
import com.example.AndroidAPIServer.dto.user.AndroidLocalUserDto;
import com.example.AndroidAPIServer.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StompChatController {

    private final ChatService chatService;

    @MessageMapping(value = "/chat/message")
    public void message(ChatMessageDto newMessage){
        chatService.sendMessage(newMessage);
    }


    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping("/api/chat/registerReservedPost")
    public ResponseEntity<String> registerReservedPost(@RequestBody ReservedPostDto dto){

        chatService.registerReservedPost(dto);

        return ResponseEntity.ok("success");
    }// registerReservedPost

}
