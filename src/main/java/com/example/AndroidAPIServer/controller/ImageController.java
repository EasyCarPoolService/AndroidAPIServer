package com.example.AndroidAPIServer.controller;


import com.example.AndroidAPIServer.dto.user.AndroidLocalUserDto;
import com.example.AndroidAPIServer.dto.user.LoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/image")
public class ImageController {


    @GetMapping("/profile")
    public ResponseEntity<FileSystemResource> getProfileImage(@RequestParam String email) throws IOException {

        String savePath = System.getProperty("user.dir") + "/profile/"+email+"_profile.jpg";

        Path path = Paths.get(savePath);

        String contentType = Files.probeContentType(path);

        FileSystemResource resource = new FileSystemResource(savePath);


        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", contentType);

        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }//return profile image



    @GetMapping("/car")
    public ResponseEntity<FileSystemResource> getCarImage(@RequestParam String email) throws IOException {

        String savePath = System.getProperty("user.dir") + "/car/"+email+"_car.jpg";

        Path path = Paths.get(savePath);

        String contentType = Files.probeContentType(path);

        FileSystemResource resource = new FileSystemResource(savePath);


        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", contentType);

        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }   // return car image
}
