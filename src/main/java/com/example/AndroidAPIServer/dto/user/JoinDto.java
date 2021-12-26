package com.example.AndroidAPIServer.dto.user;


import com.example.AndroidAPIServer.domain.user.Role;
import com.example.AndroidAPIServer.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

//public User(String name, String email, String password, String birth, String gender, String picture, Role role){

@Getter
@Setter
@Builder
@AllArgsConstructor
public class JoinDto {
    private String name;
    private String email;
    private String nickname;
    private String password;
    private String birth;
    private String gender;
    //private String picture;
    private boolean activated;
    private String role;


    public User toUserEntity(){
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .birth(birth)
                .nickname(nickname)
                .gender(gender)
                .role(Role.USER)
                .activated(true)
                .build();
    }
    public User toAdminEntity(){
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .birth(birth)
                .gender(gender)
                .activated(activated)
                .role(Role.ADMIN)
                .build();
    }


}
