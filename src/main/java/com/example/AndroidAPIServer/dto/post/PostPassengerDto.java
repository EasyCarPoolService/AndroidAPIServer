package com.example.AndroidAPIServer.dto.post;


import com.example.AndroidAPIServer.domain.entity.PostPassenger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PostPassengerDto {
    private String type;
    private String email;
    private String nickname;
    private String gender;
    private Float rate;
    private String departure;
    private String destination;
    private String departureDate;
    private String departureTime;
    private String gift;
    private String message;
    private String fcmToken;


    public PostPassenger toEntity(){
        return PostPassenger.builder()
                .type(type)
                .email(email)
                .nickname(nickname)
                .gender(gender)
                .rate(rate)
                .departure(departure)
                .destination(destination)
                .departureDate(departureDate)
                .departureTime(departureTime)
                .gift(gift)
                .message(message)
                .fcmToken(fcmToken)
                .build();
    }

}
