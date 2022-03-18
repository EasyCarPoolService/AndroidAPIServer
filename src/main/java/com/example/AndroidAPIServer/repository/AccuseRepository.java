package com.example.AndroidAPIServer.repository;

import com.example.AndroidAPIServer.domain.entity.AccuseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccuseRepository extends JpaRepository<AccuseEntity, Long> {

}
