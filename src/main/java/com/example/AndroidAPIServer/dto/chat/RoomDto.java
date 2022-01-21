package com.example.AndroidAPIServer.dto.chat;

import com.example.AndroidAPIServer.domain.entity.ChatRoomEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class RoomDto {
    private String roomId;
    private String driver;
    private String passenger;
    private String driverNickname;
    private String passengerNickname;

    private Set<WebSocketSession> sessions = new HashSet<>();
    //WebSocketSession은 Spring에서 Websocket Connection이 맺어진 세션

    // database조회하여 트랜잭션이 정상적으로 동작했는지 판단할수 있도록 수정
    public ChatRoomEntity toEntity(){

        return ChatRoomEntity.builder()
                .roomid(UUID.randomUUID().toString())
                .driver(driver)
                .passenger(passenger)
                .driverNickname(driverNickname)
                .passengerNickname(passengerNickname)
                .build();
    }

    @Builder
    public RoomDto(String driver, String passenger, String driverNickname, String passengerNickname){
        this.driver = driver;
        this.passenger = passenger;
        this.driverNickname = driverNickname;
        this.passengerNickname = passengerNickname;
    }

    public RoomDto(ChatRoomEntity entity){
        this.roomId = entity.getRoomid();
        this.driver = entity.getDriver();
        this.passenger = entity.getPassenger();
        this.driverNickname = entity.getDriverNickname();
        this.passengerNickname = entity.getPassengerNickname();
    }

}
