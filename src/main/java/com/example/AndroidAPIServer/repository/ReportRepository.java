package com.example.AndroidAPIServer.repository;

import com.example.AndroidAPIServer.domain.entity.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<ReportEntity, Long> {
}
