package com.example.AndroidAPIServer.domain.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class ChatRoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String roomid;

    @Column(nullable = false)
    private String driver;

    @Column(nullable = false)
    private String passenger;

    @Column(nullable = false)
    private String passengerNickname;

    @Column(nullable = false)
    private String driverNickname;
}
