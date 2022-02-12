package com.example.AndroidAPIServer.repository;

import com.example.AndroidAPIServer.domain.entity.PostDriver;
import com.example.AndroidAPIServer.domain.entity.PostPassenger;
import com.example.AndroidAPIServer.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostDriverRepository extends JpaRepository<PostDriver, Long> {

    Optional<User> findUserByEmail(String email);

    //시간순으로 findAll() 수행하도록 변경할것
}
