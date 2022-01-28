package com.example.AndroidAPIServer.dto.chat;


import com.example.AndroidAPIServer.domain.entity.ChatMessageEntity;
import com.example.AndroidAPIServer.domain.entity.ChatRoomEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Getter
@Setter
public class ChatMessageDto {
    private String roomId;
    private String writer;
    private String message;
    private String time;

    public void setCurrentTime(){
        LocalTime now = LocalTime.now();
        System.out.println(now);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH시 mm분");
        String formatedNow = now.format(formatter);
        this.time = formatedNow;
    }

    public ChatMessageEntity toEntity(){

        return ChatMessageEntity.builder()
                .roomid(roomId)
                .writer(writer)
                .message(message)
                .time(time)
                .build();
    }

    @Builder
    public ChatMessageDto(String roomId, String writer, String message, String time){
        this.roomId = roomId;
        this.writer = writer;
        this.message = message;
        this.time = time;
    }

    public ChatMessageDto(ChatMessageEntity entity){
        this.roomId = entity.getRoomid();
        this.writer = entity.getWriter();
        this.message = entity.getMessage();
        this.time = entity.getTime();
    }
}
