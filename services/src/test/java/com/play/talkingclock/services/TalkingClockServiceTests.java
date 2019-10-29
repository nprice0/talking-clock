package com.play.talkingclock.services;

import com.play.talkingclock.TalkingClock;
import com.play.talkingclock.strategy.EnglishBasicStrategy;
import com.play.talkingclock.strategy.TimeStrategy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TalkingClock.class})
public class TalkingClockServiceTests {

    @Autowired
    private TalkingClockService talkingClockService;

    @Autowired
    private Map<String, TimeStrategy> timeStrategyMap;

    private static DateTimeFormatter HOURS_MINUTES = DateTimeFormatter.ofPattern("HH:mm");


    @Test
    public void testClockServiceHappyPathNoStrategy() {

        //Set preferred time as convert to LocalTime object
        String requestedTime = "23:30";
        LocalTime localTime = LocalTime.parse(requestedTime, HOURS_MINUTES);

        String humanFriendlyTime = talkingClockService.translateToHumanFriendly(localTime, null);

        Assert.assertEquals("half past eleven", humanFriendlyTime);
        System.out.println(humanFriendlyTime);
    }

    @Test
    public void testClockServiceHappyPathEnglishCommonLanguageStrategy() {

        //Set preferred time as convert to LocalTime object
        String requestedTime = "23:30";
        LocalTime localTime = LocalTime.parse(requestedTime, HOURS_MINUTES);

        String humanFriendlyTime = talkingClockService.translateToHumanFriendly(localTime, "EnglishCommonLanguageStrategy");

        Assert.assertEquals("half past eleven", humanFriendlyTime);
        System.out.println(humanFriendlyTime);
    }

    @Test
    public void testClockServiceHappyPathEnglishBasicStrategy() {

        //Set preferred time as convert to LocalTime object
        String requestedTime = "23:30";
        LocalTime localTime = LocalTime.parse(requestedTime, HOURS_MINUTES);

        String humanFriendlyTime = talkingClockService.translateToHumanFriendly(localTime, EnglishBasicStrategy.class.getSimpleName());

        Assert.assertEquals("eleven thirty pm", humanFriendlyTime);
        System.out.println(humanFriendlyTime);
    }

    @Test(expected = NullPointerException.class)
    public void testClockServiceException() {
        //This wont be possible via the application CLI or web interfaces
        String humanFriendlyTime = talkingClockService.translateToHumanFriendly(null, null);
    }

    @Test
    public void testConfiguredStrategies() {
        Assert.assertEquals(timeStrategyMap.size(), 4);
        Assert.assertTrue(timeStrategyMap.containsKey("EnglishCommonLanguageStrategy"));
        Assert.assertTrue(timeStrategyMap.containsKey("WelshCommonLanguageStrategy"));
        Assert.assertTrue(timeStrategyMap.containsKey("AmericanCommonLanguageStrategy"));
        Assert.assertTrue(timeStrategyMap.containsKey("EnglishBasicStrategy"));
    }

}
