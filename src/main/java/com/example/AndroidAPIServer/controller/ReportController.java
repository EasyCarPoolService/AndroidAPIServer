package com.example.AndroidAPIServer.controller;


import com.example.AndroidAPIServer.dto.post.PostPassengerDto;
import com.example.AndroidAPIServer.dto.report.AccuseDto;
import com.example.AndroidAPIServer.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/report")
public class ReportController {

    private final ReportService reportService;

    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping("/accuse")
    public ResponseEntity<String> accuseUser(@RequestBody AccuseDto dto){
        String message = reportService.accuseUser(dto);
        return ResponseEntity.ok(message);
    }   //태워주세요 게시글 저장
}
