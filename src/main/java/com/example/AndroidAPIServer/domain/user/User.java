package com.example.AndroidAPIServer.domain.user;


import com.example.AndroidAPIServer.domain.BaseTimeEntity;
import jdk.jfr.Enabled;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Enabled
@NoArgsConstructor
@Getter
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String birth;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String picture;

    //Enumerated -> JPA로 데이터베이스 생성시 Enum값을 어떤 형태로 저장할지 결정(default : int)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String picture, Role role){
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

}
