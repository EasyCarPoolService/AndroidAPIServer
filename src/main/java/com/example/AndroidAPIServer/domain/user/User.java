package com.example.AndroidAPIServer.domain.user;


import com.example.AndroidAPIServer.domain.BaseTimeEntity;
import jdk.jfr.Enabled;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
public class User extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String birth;

    @Column(nullable = false)
    private String gender;

    //Enumerated -> JPA로 데이터베이스 생성시 Enum값을 어떤 형태로 저장할지 결정(default : int)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String nickname, String password, String birth, String gender, Role role){
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.birth = birth;
        this.gender = gender;
        //this.picture = picture;
        this.role = role;
    }

    public User update(String name) {
        this.name = name;


        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

}
