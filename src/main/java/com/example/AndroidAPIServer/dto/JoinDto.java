package com.example.AndroidAPIServer.dto;


import com.example.AndroidAPIServer.domain.user.User;
import lombok.Builder;
import lombok.Getter;

//public User(String name, String email, String password, String birth, String gender, String picture, Role role){

@Getter
public class JoinDto {
    private String name;
    private String email;
    private String password;
    private String birth;
    private String gender;
    private String picture;

    @Builder
    public JoinDto(String name, String email, String password, String birth, String gender, String picture){
        this.name = name;
        this.email = email;
        this.password = password;
        this.birth = birth;
        this.gender = gender;
        this.picture = picture;
    }

    public User toEntity(){
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .birth(birth)
                .gender(gender)
                .picture(picture)
                .build();
    }


}
