package com.example.AndroidAPIServer.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class ReservedPostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long postId;

    @Column(nullable = false)
    private String driver;

    @Column(nullable = false)
    private String passenger;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String time;



}




