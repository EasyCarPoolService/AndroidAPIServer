package com.example.AndroidAPIServer.dto.chat;

import com.example.AndroidAPIServer.domain.entity.ReservedPostEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
@AllArgsConstructor
public class ReservedPostDto {

    private Long postId;
    private String postType;
    private String driver;
    private String passenger;
    private String date;
    private String time;


    public ReservedPostEntity toEntity(){
        return ReservedPostEntity.builder()
                .postId(postId)
                .postType(postType)
                .driver(driver)
                .passenger(passenger)
                .date(date)
                .time(time)
                .build();
    }//toEntity

    public ReservedPostDto(ReservedPostEntity entity){
        this.postId = entity.getPostId();
        this.postType = entity.getPostType();
        this.driver = entity.getDriver();
        this.passenger = entity.getPassenger();
        this.date = entity.getDate();
        this.time = entity.getTime();
    } // constructor

}
