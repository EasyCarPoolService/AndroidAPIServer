package com.example.AndroidAPIServer.service;


import com.example.AndroidAPIServer.domain.entity.ChatMessageEntity;
import com.example.AndroidAPIServer.dto.chat.ChatMessageDto;
import com.example.AndroidAPIServer.dto.chat.RoomDto;
import com.example.AndroidAPIServer.repository.ChatMessageRepository;
import com.example.AndroidAPIServer.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class ChatService {

    private Map<String, RoomDto> roomDtoMap;
    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;
    private final SimpMessagingTemplate template;

    @PostConstruct  //의존성 주입이 이루어진후 초기화 수
    private void init(){
        roomDtoMap = new LinkedHashMap<>();
    }

    public String createRoomDto(RoomDto roomDto){
        return chatRoomRepository.save(roomDto.toEntity()).getRoomid();
    }

    public List<RoomDto> findAllRooms(String userEmail){
        return chatRoomRepository.findChatRoomByEmail(userEmail).stream()
                .map(RoomDto::new)
                .collect(Collectors.toList());
    }

    public void sendMessage(ChatMessageDto newMessage){
        newMessage.setCurrentTime();
        chatMessageRepository.save(newMessage.toEntity()); //채팅 메시지 저장
        template.convertAndSend("/sub/chat/room"+newMessage.getRoomId(), newMessage);
    }

    public List<ChatMessageDto> findMessageByRoomId(String roomId){

        try{
            return chatMessageRepository.findMessageByRoomId(roomId).stream()
                    .map(ChatMessageDto::new)
                    .collect(Collectors.toList());
        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }


}
