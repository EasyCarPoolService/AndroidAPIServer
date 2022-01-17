package com.example.AndroidAPIServer.repository;

import com.example.AndroidAPIServer.domain.entity.PostPassenger;
import com.example.AndroidAPIServer.domain.entity.User;
import com.example.AndroidAPIServer.dto.post.PostPassengerDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostPassengerRepository extends JpaRepository<PostPassenger, Long>{ Optional<User> findUserByEmail(String email);
}
