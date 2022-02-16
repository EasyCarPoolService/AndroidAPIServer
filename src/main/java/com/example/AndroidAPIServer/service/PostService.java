package com.example.AndroidAPIServer.service;


import com.example.AndroidAPIServer.domain.entity.PostDriver;
import com.example.AndroidAPIServer.domain.entity.PostPassenger;
import com.example.AndroidAPIServer.dto.post.PostDriverDto;
import com.example.AndroidAPIServer.dto.post.PostPassengerDto;
import com.example.AndroidAPIServer.dto.post.UserPostDto;
import com.example.AndroidAPIServer.dto.user.AndroidLocalUserDto;
import com.example.AndroidAPIServer.repository.PostDriverRepository;
import com.example.AndroidAPIServer.repository.PostPassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostPassengerRepository postPassengerRepository;
    private final PostDriverRepository postDriverRepository;

    //태워주세요 게시글 등록
    @Transactional
    public String savePassengerPost(PostPassengerDto dto){
        postPassengerRepository.save(dto.toEntity());
        return "ok";
    }   //태워주세요 게식글 저장


    //타세요 게시글 등록
    @Transactional
    public String saveDriverPost(PostDriverDto dto){
        postDriverRepository.save(dto.toEntity());
        return "ok";
    }   // 타세요 게시글 저장


    @Transactional
    public List<PostPassenger> getPassengerPost(){
        return postPassengerRepository.findAll();
    }   // 태워주세요 게시글 조회

    @Transactional
    public List<PostDriver> getDriverPost(){
        return postDriverRepository.findAll();
    }   //타세요 게시글 조회


    @Transactional
    public UserPostDto getUserPostData(AndroidLocalUserDto androidLocalUserDto) {

        List<PostPassenger> postPassengers = postPassengerRepository.findPassengerPostByEmail(androidLocalUserDto.getEmail());
        List<PostDriver> postDrivers = postDriverRepository.findDriverPostByEmail(androidLocalUserDto.getEmail());

        return UserPostDto.builder()
                .passenger(Integer.toString(postPassengers.size()))
                .driver(Integer.toString(postDrivers.size()))
                .ongoing("0")
                .build();
    }//getUserPostDat()
}
