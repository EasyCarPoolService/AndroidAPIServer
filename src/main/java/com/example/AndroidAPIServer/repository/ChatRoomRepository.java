package com.example.AndroidAPIServer.repository;


import com.example.AndroidAPIServer.domain.entity.ChatRoomEntity;

import com.example.AndroidAPIServer.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, Long> {

    //select * from testTBL where name1='kim' or name2='kim';
    @Query("SELECT c FROM ChatRoomEntity c WHERE c.passenger = :email OR c.driver = :email")
    public List<ChatRoomEntity> findChatRoomByEmail(@Param("email") String email);

    
    //select * from chat_room_entity where post_type = 'driver' AND post_id=2 AND passenger='lee' AND driver='kim';

    @Query("SELECT c FROM ChatRoomEntity c WHERE c.postType = :postType AND c.postId = :postId AND c.driver = :driver AND c.passenger = :passenger")
    Optional<ChatRoomEntity> findChatRoomByDto(@Param("postType") String postType,
                                                @Param("postId") Long postId,
                                                @Param("driver") String driver,
                                                @Param("passenger") String passenger);
    // create room 수행시 기존에 방이 존재하는지 확인하기 위해 chatRoomDto와 일치하는 방이 존재하는지 조회


}
