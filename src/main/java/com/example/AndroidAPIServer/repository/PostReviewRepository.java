package com.example.AndroidAPIServer.repository;

import com.example.AndroidAPIServer.domain.entity.PostPassenger;
import com.example.AndroidAPIServer.domain.entity.PostReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostReviewRepository extends JpaRepository<PostReviewEntity, Long> {


}
