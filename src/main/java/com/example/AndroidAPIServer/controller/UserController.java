package com.example.AndroidAPIServer.controller;

import com.example.AndroidAPIServer.dto.user.AndroidLocalUserDto;
import com.example.AndroidAPIServer.dto.user.JoinDto;
import com.example.AndroidAPIServer.test.TestDto;
import com.example.AndroidAPIServer.jwt.TokenProvider;
import com.example.AndroidAPIServer.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    private final UserService userService;

    private final TokenProvider tokenProvider;

    //순서 회원가입 진행완료 후 이어서 사진 저장하도록 설정
    @PostMapping("/signup")
    public ResponseEntity<String> signup(
            @RequestParam(value = "profile_image", required = false) MultipartFile profile_image,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("nickname") String nickname,
            @RequestParam("password") String password,
            @RequestParam("birth") String birth,
            @RequestParam("gender") String gender,
            @RequestParam("fcmToken") String fcmToken
    ){

        String responseMessage;

        System.out.println("fcmToken is "+fcmToken.toString());

        //join Dto구성 코드 작성
        JoinDto joinDto = JoinDto.builder()
                .name(name)
                .email(email)
                .nickname(nickname)
                .password(password)
                .birth(birth)
                .gender(gender)
                .driverAuthentication(false)
                .fcmToken(fcmToken)
                .build();


        try{
            responseMessage = userService.signup(joinDto);

            //signup 수행후 이미지 저장 수행
            try {
                String origFilename = profile_image.getOriginalFilename();
                String filename = origFilename.toString();

                //savePath -> 현재 프로젝트 폴더내 존재하는 files폴더의 경로
                String savePath = System.getProperty("user.dir") + "/profile";

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
                profile_image.transferTo(new File(filePath));

            } catch(Exception e) {
                e.printStackTrace();
            }


        }catch(Exception e){
            responseMessage = e.getMessage();
        }
        return ResponseEntity.ok(responseMessage);
    }

    //@RequestMapping(method= RequestMethod.GET)
    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping("/getUserData")
    public AndroidLocalUserDto getUserData(@RequestHeader("Authorization") String value) {
        System.out.println("Authorization=" + value);
        return userService.getUserData(value);
    }

    //check   user Table의 driverAuthentication True로 변경 하도록 수정!
    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping("/driverAuth")
    public ResponseEntity<String> authDriver(@RequestParam("idImage") MultipartFile id_image,
                                                       @RequestParam("carImage") MultipartFile car_image,
                                                       @RequestParam("email") String email,
                                                       @RequestParam("carNumber") String carNumber,
                                                       @RequestParam("manufacturer") String manufacturer,
                                                       @RequestParam("model") String model) {


        // service결과에 따른 출력 메시지 작성하도록 변경! -> Transaction 수정 가능 하도록 변경 필요
        String responseMessage = userService.authDriver(id_image, car_image, email, carNumber, manufacturer, model);

        return ResponseEntity.ok(responseMessage);
    }

    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping("/getDriverAuth")
    public AndroidLocalUserDto getDriverAuth(@RequestBody AndroidLocalUserDto androidLocalUserDto){

        System.out.println(androidLocalUserDto.getEmail());

        return userService.getDriverAuth(androidLocalUserDto);
    } // getDriverAuth()


    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping("/editProfile")
    public ResponseEntity<String> editProfile(
            @RequestParam("email") String email,
            @RequestParam(value = "profile_image", required = false) MultipartFile profile_image,
            @RequestParam("nickname") String nickname,
            @RequestParam("gender") String gender,
            @RequestParam("introduce_message") String introduce_message
                                           ){
        String responseMessage = "transaction error";

        try{
            responseMessage = userService.editProfile(email, nickname, gender, introduce_message);

            //signup 수행후 이미지 저장 수행
            try {
                String origFilename = profile_image.getOriginalFilename();
                String filename = origFilename.toString();

                //savePath -> 현재 프로젝트 폴더내 존재하는 files폴더의 경로
                String savePath = System.getProperty("user.dir") + "/profile";

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
                profile_image.transferTo(new File(filePath));

            } catch(Exception e) {
                e.printStackTrace();
            }

        }catch(Exception e){
            responseMessage = e.getMessage();
        }


        return ResponseEntity.ok(responseMessage);
    } // getDriverAuth()

}
