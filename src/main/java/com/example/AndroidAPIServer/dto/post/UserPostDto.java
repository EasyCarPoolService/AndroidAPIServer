package com.example.AndroidAPIServer.dto.post;


import com.example.AndroidAPIServer.domain.entity.PostPassenger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserPostDto {

    private String driver;
    private String passenger;
    private String ongoing;
}
