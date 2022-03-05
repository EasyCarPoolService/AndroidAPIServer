package com.example.AndroidAPIServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchScheduler {


    @Scheduled(cron = "0/10 * * * * *")
    public void testSchedule(){

        System.out.println("test");
    }

}
