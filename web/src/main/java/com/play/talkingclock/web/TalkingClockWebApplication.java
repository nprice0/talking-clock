package com.play.talkingclock.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.play.talkingclock")
public class TalkingClockWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TalkingClockWebApplication.class, args);
    }

}