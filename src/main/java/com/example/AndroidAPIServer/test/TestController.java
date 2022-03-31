package com.example.AndroidAPIServer.test;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/test")
public class TestController {

    private final TestRepository testRepository;

    @PostMapping("/databasetest")
    public ResponseEntity<String> test(@RequestBody TestDto testDto){
        System.out.println(testDto.getMessage());

        testRepository.save(testDto.toEntity());

        return ResponseEntity.ok("Success");
    }


}
