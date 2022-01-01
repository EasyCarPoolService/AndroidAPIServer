package com.example.AndroidAPIServer.controller;

import com.example.AndroidAPIServer.dto.user.AndroidLocalUserDto;
import com.example.AndroidAPIServer.dto.user.JoinDto;
import com.example.AndroidAPIServer.dto.user.TestDto;
import com.example.AndroidAPIServer.jwt.TokenProvider;
import com.example.AndroidAPIServer.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    private final UserService userService;

    private final TokenProvider tokenProvider;

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

    //@RequestMapping(method= RequestMethod.GET)
    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping("/getUserData")
    public AndroidLocalUserDto getUserData(@RequestHeader("Authorization") String value) {
        System.out.println("Authorization=" + value);
        return userService.getUserData(value);
    }

}
