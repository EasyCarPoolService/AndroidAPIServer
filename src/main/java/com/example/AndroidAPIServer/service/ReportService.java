package com.example.AndroidAPIServer.service;


import com.example.AndroidAPIServer.dto.report.AccuseDto;
import com.example.AndroidAPIServer.repository.AccuseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReportService {

    private final AccuseRepository accuseRepository;

    @Transactional
    public String accuseUser(AccuseDto dto){
        accuseRepository.save(dto.toEntity());
        return "success";
    }




}
