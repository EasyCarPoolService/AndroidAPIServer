package com.example.AndroidAPIServer.controller;

import com.example.AndroidAPIServer.dto.user.JoinDto;
import com.example.AndroidAPIServer.dto.user.TestDto;
import com.example.AndroidAPIServer.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody JoinDto joinDto){

        String responseMessage;

        try{
            responseMessage = userService.signup(joinDto);
        }catch(Exception e){
            responseMessage = e.getMessage();
        }
        return ResponseEntity.ok(responseMessage);
    }

    @PostMapping("/test")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<String> test(@RequestBody TestDto testDto){
        System.out.println(testDto.getMessage());

        return ResponseEntity.ok("Success");
    }

}
