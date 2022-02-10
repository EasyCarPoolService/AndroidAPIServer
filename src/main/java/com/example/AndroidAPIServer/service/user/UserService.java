package com.example.AndroidAPIServer.service.user;

import com.example.AndroidAPIServer.domain.entity.User;
import com.example.AndroidAPIServer.dto.user.AndroidLocalUserDto;
import com.example.AndroidAPIServer.dto.user.JoinDto;
import com.example.AndroidAPIServer.dto.user.LoginDto;
import com.example.AndroidAPIServer.jwt.JwtFilter;
import com.example.AndroidAPIServer.jwt.TokenProvider;
import com.example.AndroidAPIServer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @Transactional
    public String signup(JoinDto joinDto) {
        if (userRepository.findUserByEmail(joinDto.getEmail()).orElse(null) != null) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        joinDto.setPassword(encoder.encode(joinDto.getPassword()));


        return userRepository.save(joinDto.toUserEntity()).getId().toString();
    }//signup

    @Transactional
    public ResponseEntity<AndroidLocalUserDto> login(LoginDto loginDto){
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());

        try{
            // authenticationToken을 가지고 authenticate수행 중 email과 password가 일치하지 않을경우 이후의 코드 수행하지 않음
            // authtenticate 메서드 호출시 -> CustomUserDetailsService의 loadUserByName method가 실행됨
            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = tokenProvider.createToken(authentication);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

            User user = userRepository.findUserByEmail(loginDto.getEmail()).get();

            //check
            AndroidLocalUserDto dto = AndroidLocalUserDto.builder()
                    .nickname(user.getNickname())
                    .email(user.getEmail())
                    .gender(user.getGender())
                    .token(jwt)
                    .driverAuthentication(user.getDriverAuthentication())
                    .fcmToken(user.getFcmToken())
                    .build();

            return new ResponseEntity<>(dto, httpHeaders, HttpStatus.OK);
        }catch (Exception e){
            String message = e.getMessage();
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//login


    //token 인중후 응답데이터로 유저 정보 전송 -> Android Client 에서 LocalUserData SingleTon패턴 적용
    @Transactional
    public AndroidLocalUserDto getUserData(String value){

        //resolveToken - return email of token
        String token = value.substring(7);
        String email = tokenProvider.resolveToken(token);
        User user = userRepository.findUserByEmail(email).get();

        if(user != null){
            return AndroidLocalUserDto.builder()
                    .email(user.getEmail())
                    .nickname(user.getNickname())
                    .token(token)
                    .gender(user.getGender())
                    .driverAuthentication(user.getDriverAuthentication())
                    .build();
        }else{
            return null;
        }
    }//getUserData

    @Transactional
    public void authDriver(MultipartFile id_image,
                           MultipartFile car_image,
                           String name,
                           String email,
                           String nickname){

        try {
            String id_originalFileName = id_image.getOriginalFilename();
            String id_fileName = id_originalFileName.toString();

            String car_originalFileName = car_image.getOriginalFilename();
            String car_fileName = car_originalFileName.toString();

            //savePath -> 현재 프로젝트 폴더내 존재하는 files폴더의 경로
            String id_savePath = System.getProperty("user.dir") + "/userId";
            String car_savePath = System.getProperty("user.dir") + "/car";

            // /files폴더가 존재하지 않으면 생성
            if (!new File(id_savePath).exists()) {
                try{
                    new File(id_savePath).mkdir();
                }
                catch(Exception e){
                    e.getStackTrace();
                }
            }
            if (!new File(car_savePath).exists()) {
                try{
                    new File(car_savePath).mkdir();
                }
                catch(Exception e){
                    e.getStackTrace();
                }
            }
            //   현재프로젝트경로/files/filename   ->  filename == (androdi)fileName 변수
            String id_filePath = id_savePath + "/" + id_fileName;
            String car_filePath = car_savePath + "/" + car_fileName;

            // 파일 저장
            id_image.transferTo(new File(id_filePath));
            car_image.transferTo(new File(car_filePath));

        } catch(Exception e) {
            e.printStackTrace();
        }

    }//authDriver



}
