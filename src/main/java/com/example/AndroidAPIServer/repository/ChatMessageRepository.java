package com.example.AndroidAPIServer.repository;

import com.example.AndroidAPIServer.domain.entity.ChatMessageEntity;
import com.example.AndroidAPIServer.domain.entity.ChatRoomEntity;
import com.example.AndroidAPIServer.domain.entity.PostPassenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ChatMessageRepository extends JpaRepository<ChatMessageEntity, Long> {

    @Query("SELECT m FROM ChatMessageEntity m WHERE m.roomid = :roomId")
    public List<ChatMessageEntity> findMessageByRoomId(@Param("roomId") String roomId);

    @Transactional
    @Modifying
    @Query("DELETE FROM ChatMessageEntity m WHERE m.roomid = :roomId")
    public void deleteMessageByRoomID(@Param("roomId") String roomId);
    //leave chatroom 수행시 해당 방에 해당하는 메시지 삭제
}
