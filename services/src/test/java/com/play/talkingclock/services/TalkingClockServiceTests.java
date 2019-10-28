package com.play.talkingclock.services;

import com.play.talkingclock.TalkingClock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Assert;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={TalkingClock.class})
public class TalkingClockServiceTests {

    @Autowired
    private TalkingClockService talkingClockService;

    private static DateTimeFormatter HOURS_MINUTES = DateTimeFormatter.ofPattern("HH:mm");


    @Test
    public void testClockServiceHappyPath() {

        //Set preferred time as convert to LocalTime object
        String requestedTime = "23:30";
        LocalTime localTime = LocalTime.parse(requestedTime, HOURS_MINUTES);

        String humanFriendlyTime = talkingClockService.translateToHumanFriendly(localTime);

        Assert.assertEquals("half past eleven", humanFriendlyTime);
        System.out.println(humanFriendlyTime);

    }

    @Test(expected = DateTimeParseException.class)
    public void testClockServiceException() {

        //Set preferred time as convert to LocalTime object
        String requestedTime = "27:30";
        LocalTime localTime = LocalTime.parse(requestedTime, HOURS_MINUTES);

        String humanFriendlyTime = talkingClockService.translateToHumanFriendly(localTime);


    }





}
