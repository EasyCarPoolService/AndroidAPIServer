package com.example.AndroidAPIServer.controller;

import com.example.AndroidAPIServer.dto.JoinDto;
import com.example.AndroidAPIServer.service.join.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final JoinService joinService;

    @PostMapping("/api/user/signup")
    public Long signup(JoinDto joinDto) {
        System.out.println("access successfully");
        return joinService.save(joinDto);
    }

}
