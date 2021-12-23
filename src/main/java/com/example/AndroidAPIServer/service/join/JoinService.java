package com.example.AndroidAPIServer.service.join;


import com.example.AndroidAPIServer.domain.user.User;
import com.example.AndroidAPIServer.domain.user.UserRepository;
import com.example.AndroidAPIServer.dto.JoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


/*
UserDetails?
=> SpringSecurity에서 사용자의 정보를 담는 인터페이스

UserDetailService?
=> Spring Security에서 유저의 정보를 가져오는 인터페이스

OAuth2User ?
=> 구글로그인과 같은 OAuth로그인 사용시 OAuth2User타입을 authentication으로 사용
 */


@RequiredArgsConstructor
@Service
public class JoinService implements UserDetailsService {

    private final UserRepository userRepository;


    //사용자 정보를 CustomUserDetails형으로 가져옴
    //해당 username의 정보가 없다면 예외발생
    //해당 username의 정보 존재한다면 사용자 정보 담긴 user리턴
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public Long save(JoinDto joinDto) {
        // password는 암호화를 거친후 저장
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        joinDto.setPassword(encoder.encode(joinDto.getPassword()));

        //dto내 String role이 "admin"이면 User Entity의 role = ROLE_ADMIN
        if(joinDto.getRole().equals("admin")){
            return userRepository.save(joinDto.toAdminEntity()).getId();
        }

        return userRepository.save(joinDto.toUserEntity()).getId();
    }



}
