package com.play.talkingclock.strategy;

import com.play.talkingclock.strategy.commonlanguage.CommonLanguageStrategy;
import com.play.talkingclock.strategy.commonlanguage.languages.Welsh;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class WelshCommonLanguageStrategyTest {

    @Test
    public void testAnteMeridiem() {

        TimeStrategy welshCommonLanguageStrategy = new CommonLanguageStrategy(new Welsh());

        LocalTime localTime = LocalTime.of(0, 0);
        assertEquals("hanner nos", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(11, 0);
        assertEquals("un ar ddeg o'r gloch", welshCommonLanguageStrategy.getTimeInWords(localTime));

    }


    @Test
    public void testPostMeridiem() {

        TimeStrategy welshCommonLanguageStrategy = new CommonLanguageStrategy(new Welsh());

        LocalTime localTime = LocalTime.of(12, 0);
        assertEquals("hanner dydd", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(23, 0);
        assertEquals("un ar ddeg o'r gloch", welshCommonLanguageStrategy.getTimeInWords(localTime));

    }


    @Test
    public void testMinutes() {

        TimeStrategy welshCommonLanguageStrategy = new CommonLanguageStrategy(new Welsh());

        LocalTime localTime = LocalTime.of(0, 10);
        assertEquals("deg wedi deuddeg", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 15);
        assertEquals("chwarter wedi deuddeg", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 30);
        assertEquals("hanner awr wedi deuddeg", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 40);
        assertEquals("ugain i un", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 45);
        assertEquals("chwarter i un", welshCommonLanguageStrategy.getTimeInWords(localTime));

    }


    @Test
    public void testHours() {

        TimeStrategy welshCommonLanguageStrategy = new CommonLanguageStrategy(new Welsh());

        LocalTime localTime = LocalTime.of(1, 0);
        assertEquals("un o'r gloch", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(2, 0);
        assertEquals("dau o'r gloch", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(3, 0);
        assertEquals("tri o'r gloch", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(4, 0);
        assertEquals("pedwar o'r gloch", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(5, 0);
        assertEquals("pump o'r gloch", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(6, 0);
        assertEquals("chwech o'r gloch", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(7, 0);
        assertEquals("saith o'r gloch", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(8, 0);
        assertEquals("wyth o'r gloch", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(9, 0);
        assertEquals("naw o'r gloch", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(10, 0);
        assertEquals("deg o'r gloch", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(11, 0);
        assertEquals("un ar ddeg o'r gloch", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(12, 0);
        assertEquals("hanner dydd", welshCommonLanguageStrategy.getTimeInWords(localTime));

    }

}