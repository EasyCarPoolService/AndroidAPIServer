package com.example.AndroidAPIServer.controller;

import com.example.AndroidAPIServer.dto.user.AndroidLocalUserDto;
import com.example.AndroidAPIServer.dto.user.JoinDto;
import com.example.AndroidAPIServer.dto.user.TestDto;
import com.example.AndroidAPIServer.jwt.TokenProvider;
import com.example.AndroidAPIServer.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.Part;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.security.Provider;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    private final UserService userService;

    private final TokenProvider tokenProvider;


    /*@Part profile_image : MultipartBody.Part?,
    @Part("name") name: RequestBody?,
    @Part("email") email: RequestBody?,
    @Part("nickname") nickname: RequestBody?,
    @Part("password") password: RequestBody?,
    @Part("birth") birth: RequestBody?,
    @Part("gender") gender: RequestBody?,
    @Part("driverAuthentication") driverAuthentication: RequestBody?,*/


    //순서 회원가입 진행완료 후 이어서 사진 저장하도록 설정
    @PostMapping("/signup")
    public ResponseEntity<String> signup(
            @RequestParam("profile_image") MultipartFile profile_image,
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

    //check   user Table의 driverAuthentication True로 변경 하도록 수정!
    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping("/driverAuth")
    public ResponseEntity<String> authDriver(@RequestParam("idImage") MultipartFile id_image,
                                                       @RequestParam("carImage") MultipartFile car_image,
                                                       @RequestParam("carNumber") String name,
                                                       @RequestParam("manufacturer") String email,
                                                       @RequestParam("model") String nickname) {


        // service결과에 따른 출력 메시지 작성하도록 변경!
        userService.authDriver(id_image, car_image, name, email, nickname);

        String responseMessage = "ok";
        return ResponseEntity.ok(responseMessage);
    }


}
