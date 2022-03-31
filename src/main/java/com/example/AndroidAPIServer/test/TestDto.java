package com.example.AndroidAPIServer.test;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestDto {
    String message;

    public testTBL toEntity(){

        return testTBL.builder().test(message).build();

    }


}
