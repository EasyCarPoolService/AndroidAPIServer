package com.example.AndroidAPIServer.dto.post;


import com.example.AndroidAPIServer.domain.entity.PostDriver;
import com.example.AndroidAPIServer.domain.entity.PostPassenger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PostDriverDto {

    private String type;
    private String email;
    private String nickname;
    private String gender;
    private String departure;
    private String destination;
    private String departureDate;
    private String departureTime;
    private String gift;
    private String message;
    private String fcmToken;


    public PostDriver toEntity(){
        return PostDriver.builder()
                .type(type)
                .email(email)
                .nickname(nickname)
                .gender(gender)
                .departure(departure)
                .destination(destination)
                .departureDate(departureDate)
                .departureTime(departureTime)
                .gift(gift)
                .message(message)
                .fcmToken(fcmToken)
                .build();
    }//toEntity

}
