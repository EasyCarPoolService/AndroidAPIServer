package com.example.AndroidAPIServer.domain.entity;


import com.example.AndroidAPIServer.domain.BaseTimeEntity;
import com.example.AndroidAPIServer.domain.user.Role;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class User extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String birth;

    @Column(nullable = false)
    private String gender;

    @Column(name = "activated")
    private boolean activated;

    //Enumerated -> JPA로 데이터베이스 생성시 Enum값을 어떤 형태로 저장할지 결정(default : int)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

}
