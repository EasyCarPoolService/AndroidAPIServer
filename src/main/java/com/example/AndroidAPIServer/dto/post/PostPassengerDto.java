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
    private String email;
    private String nickname;
    private String gender;
    private String departure;
    private String destination;
    private String departureDate;
    private String departureTime;
    private List<String> gift;
    private String message;

    public PostPassenger toEntity(){
        return PostPassenger.builder()
                .email(email)
                .nickname(nickname)
                .gender(gender)
                .departure(departure)
                .destination(destination)
                .departureDate(departureDate)
                .departureTime(departureTime)
                .gift(giftToString())
                .message(message)
                .build();
    }

    // 추후 String으로 변환하는 과정을 수행하지 않고 테이블을 생성하는 것으로 수정할것
    private String giftToString(){
        String result="";
        for (int i = 0; i < gift.size(); i++) {
            result = result +", "+ gift.get(i);
        }
        return result;
    }


}
