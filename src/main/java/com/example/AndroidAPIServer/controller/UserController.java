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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

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

    //check
    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping("/driverAuth")
    public ResponseEntity<String> driverAuthentication(@RequestParam("idImage")MultipartFile id_image, @RequestParam("carImage")MultipartFile car_image) {

        String responseMessage = "ok";

        System.out.println(id_image.getOriginalFilename());
        System.out.println(car_image.getOriginalFilename());

        /*try {
            String origFilename = files.getOriginalFilename();
            String filename = origFilename.toString();

            //savePath -> 현재 프로젝트 폴더내 존재하는 files폴더의 경로
            String savePath = System.getProperty("user.dir") + "/files";

            // /files폴더가 존재하지 않으면 생성
            if (!new File(savePath).exists()) {
                try{
                    new File(savePath).mkdir();
                }
                catch(Exception e){
                    e.getStackTrace();
                }
            }

            //   현재프로젝트경로/files/filename   ->  filename == (androdi)fileName 변수
            String filePath = savePath + "/" + filename;

            // 파일 저장
            files.transferTo(new File(filePath));

        } catch(Exception e) {
            e.printStackTrace();
        }*/
        return ResponseEntity.ok(responseMessage);
    }


}
