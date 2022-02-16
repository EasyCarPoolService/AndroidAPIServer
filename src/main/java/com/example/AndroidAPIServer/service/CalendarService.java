package com.example.AndroidAPIServer.service;


import com.example.AndroidAPIServer.domain.entity.PostDriver;
import com.example.AndroidAPIServer.domain.entity.PostPassenger;
import com.example.AndroidAPIServer.dto.calendar.CalendarPostDto;
import com.example.AndroidAPIServer.dto.post.UserPostDto;
import com.example.AndroidAPIServer.dto.user.AndroidLocalUserDto;
import com.example.AndroidAPIServer.repository.PostDriverRepository;
import com.example.AndroidAPIServer.repository.PostPassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CalendarService {

    private final PostPassengerRepository postPassengerRepository;
    private final PostDriverRepository postDriverRepository;


    @Transactional
    public List<CalendarPostDto> getCalendarPostData(AndroidLocalUserDto androidLocalUserDto) {

        List<CalendarPostDto> postPassengers = postPassengerRepository.findPassengerPostByEmail(androidLocalUserDto.getEmail()).stream()
                .map(CalendarPostDto::new)
                .collect(Collectors.toList());

        List<CalendarPostDto> postDrivers = postDriverRepository.findDriverPostByEmail(androidLocalUserDto.getEmail()).stream()
                .map(CalendarPostDto::new)
                .collect(Collectors.toList());

        List<CalendarPostDto> mergedList = new ArrayList<>();

        mergedList.addAll(postPassengers);
        mergedList.addAll(postDrivers);

        return mergedList;
    }//getUserPostDat()

}
