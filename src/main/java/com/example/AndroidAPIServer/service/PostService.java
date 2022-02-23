package com.example.AndroidAPIServer.service;


import com.example.AndroidAPIServer.domain.entity.PostDriver;
import com.example.AndroidAPIServer.domain.entity.PostPassenger;
import com.example.AndroidAPIServer.dto.chat.RoomDto;
import com.example.AndroidAPIServer.dto.post.PostDriverDto;
import com.example.AndroidAPIServer.dto.post.PostDto;
import com.example.AndroidAPIServer.dto.post.PostPassengerDto;
import com.example.AndroidAPIServer.dto.post.UserPostDto;
import com.example.AndroidAPIServer.dto.user.AndroidLocalUserDto;
import com.example.AndroidAPIServer.repository.PostDriverRepository;
import com.example.AndroidAPIServer.repository.PostPassengerRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<PostDto> getPassengerPost(){
        return postPassengerRepository.findAll().stream()
                .map(PostDto::new)
                .collect(Collectors.toList());
    }   // 태워주세요 게시글 조회

    @Transactional
    public List<PostDto> getDriverPost(){
        return postDriverRepository.findAll().stream()
                .map(PostDto::new)
                .collect(Collectors.toList());
    }   //타세요 게시글 조회

    @Transactional
    public List<PostDto> getUserPost(AndroidLocalUserDto androidLocalUserDto){

        List<PostDto> postPassenger = postPassengerRepository.findPassengerPostByEmail(androidLocalUserDto.getEmail()).stream()
                .map(PostDto::new)
                .collect(Collectors.toList());

        List<PostDto> postDriver = postDriverRepository.findDriverPostByEmail(androidLocalUserDto.getEmail()).stream()
                .map(PostDto::new)
                .collect(Collectors.toList());

        List<PostDto> posts = new ArrayList<PostDto>();
        posts.addAll(postDriver);
        posts.addAll(postPassenger);

        return posts;
    }   //엑세스한 유저가 작성한 게시글 조회


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

    @Transactional
    public PostDto findPostById(RoomDto roomDto){
        if(roomDto.getPostType().equals("passenger")){  //요청 게시글이 태워주세요
            PostPassenger postPassenger = postPassengerRepository.findById(roomDto.getPostId())
                    .orElseThrow(()->
                            new IllegalArgumentException("해당 게시글이 없습니다."));

            return new PostDto(postPassenger);
        }else{  //요청 게시글이 타세요
            PostDriver postDriver = postDriverRepository.findById(roomDto.getPostId())
                    .orElseThrow(()->
                            new IllegalArgumentException("해당 게시글이 없습니다."));

            return new PostDto(postDriver);
        }

    }//findPostById()
}
