package com.example.AndroidAPIServer.service;


import com.example.AndroidAPIServer.domain.entity.ChatRoomEntity;
import com.example.AndroidAPIServer.dto.chat.RoomDto;
import com.example.AndroidAPIServer.repository.ChatRoomRepository;
import com.example.AndroidAPIServer.repository.PostPassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class ChatService {

    private Map<String, RoomDto> roomDtoMap;
    private final ChatRoomRepository chatRoomRepository;

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

}
