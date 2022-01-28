package com.example.AndroidAPIServer.repository;

import com.example.AndroidAPIServer.domain.entity.ChatMessageEntity;
import com.example.AndroidAPIServer.domain.entity.ChatRoomEntity;
import com.example.AndroidAPIServer.domain.entity.PostPassenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ChatMessageRepository extends JpaRepository<ChatMessageEntity, Long> {

    /*@Query("SELECT m FROM ChatRoomEntity m WHERE m.roomid = :roomId OR m.driver = :roomId")
    public List<ChatMessageEntity> findMessageByRoomId(@Param("roomId") String roomId);*/

    @Query("SELECT m FROM ChatMessageEntity m WHERE m.roomid = :roomId")
    public List<ChatMessageEntity> findMessageByRoomId(@Param("roomId") String roomId);
}
