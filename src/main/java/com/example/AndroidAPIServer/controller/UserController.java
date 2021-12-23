package com.example.AndroidAPIServer.controller;

import com.example.AndroidAPIServer.dto.JoinDto;
import com.example.AndroidAPIServer.service.join.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    private final JoinService joinService;

    @PostMapping("/signup")
    public Long signup(@RequestBody JoinDto joinDto) {
        System.out.println("access successfully");
        System.out.println(joinDto.getNickname());

        return joinService.save(joinDto);
    }

}
