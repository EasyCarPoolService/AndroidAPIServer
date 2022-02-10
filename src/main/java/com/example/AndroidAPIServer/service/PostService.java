package com.example.AndroidAPIServer.service;


import com.example.AndroidAPIServer.domain.entity.PostPassenger;
import com.example.AndroidAPIServer.dto.post.PostPassengerDto;
import com.example.AndroidAPIServer.repository.PostPassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostPassengerRepository postPassengerRepository;

    //태워주세요 게시글 등록
    @Transactional
    public String savePassengerPost(PostPassengerDto dto){

        postPassengerRepository.save(dto.toEntity());

        return "ok";

        /*try{
            postPassengerRepository.save(dto.toEntity());
            return "success";
        }catch(Exception e){
            return "fail";
        }*/
    }

    @Transactional
    public List<PostPassenger> getPassengerPost(){
        return postPassengerRepository.findAll();
    }

}
