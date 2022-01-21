package com.example.AndroidAPIServer.repository;


import com.example.AndroidAPIServer.domain.entity.ChatRoomEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, Long> {

    //select * from testTBL where name1='kim' or name2='kim';
    @Query("SELECT c FROM ChatRoomEntity c WHERE c.passenger = :email OR c.driver = :email")
    public List<ChatRoomEntity> findChatRoomByEmail(@Param("email") String email);

}
