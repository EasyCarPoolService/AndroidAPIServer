package com.example.AndroidAPIServer.repository;


import com.example.AndroidAPIServer.domain.entity.ChatMessageEntity;
import com.example.AndroidAPIServer.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long>{
    //기존의 회원인지 새로 유입된 회원인지 식별하기 위해 사용

    @Transactional
    Optional<User> findUserByEmail(String email);


    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.driverAuthentication = true WHERE u.email = :email")
    void updateDriverAuthentication(String email);

}




