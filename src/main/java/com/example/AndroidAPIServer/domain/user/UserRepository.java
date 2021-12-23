package com.example.AndroidAPIServer.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
    //기존의 회원인지 새로 유입된 회원인지 식별하기 위해 사용
    Optional<User> findByEmail(String email);
}
