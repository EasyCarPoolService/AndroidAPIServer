package com.example.AndroidAPIServer.dto.user;


import com.example.AndroidAPIServer.domain.user.Role;
import com.example.AndroidAPIServer.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


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
    private Boolean driverAuthentication;
    private String fcmToken;
    //private String picture;
    private boolean activated;
    private String role;

    //check driverAuthentication -> 임시로 true
    public User toUserEntity(){
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .birth(birth)
                .nickname(nickname)
                .gender(gender)
                .rate(0)    //최초 회원가입 -> User Rate = 0
                //.driverAuthentication(driverAuthentication)
                .driverAuthentication(false)
                .fcmToken(fcmToken)
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
                .rate(0)
                .driverAuthentication(true) //관리자의 경우 default = true
                .activated(activated)
                .role(Role.ADMIN)
                .build();
    }

}
