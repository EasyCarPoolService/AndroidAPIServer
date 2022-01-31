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
    }

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
            AndroidLocalUserDto dto = AndroidLocalUserDto.builder()
                    .nickname(user.getNickname())
                    .email(user.getEmail())
                    .gender(user.getGender())
                    .token(jwt)
                    .driverAuthentication(user.getDriverAuthentication())
                    .build();

            return new ResponseEntity<>(dto, httpHeaders, HttpStatus.OK);
        }catch (Exception e){
            String message = e.getMessage();
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


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
    }
}
