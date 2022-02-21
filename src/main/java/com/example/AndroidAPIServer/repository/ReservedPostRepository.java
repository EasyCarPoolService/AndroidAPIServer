package com.example.AndroidAPIServer.repository;

import com.example.AndroidAPIServer.domain.entity.PostPassenger;
import com.example.AndroidAPIServer.domain.entity.ReservedPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservedPostRepository extends JpaRepository<ReservedPostEntity, Long> {

    @Query("SELECT p FROM ReservedPostEntity p WHERE p.driver = :email OR p.passenger = :email")
    public List<ReservedPostEntity> findReservedPostByEmail(@Param("email") String email);

}

