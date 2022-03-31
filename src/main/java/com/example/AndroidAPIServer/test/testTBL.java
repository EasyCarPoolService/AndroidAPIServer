package com.example.AndroidAPIServer.test;


import com.example.AndroidAPIServer.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class testTBL{

    @Id
    @Column(nullable = false)
    private String test;
}
