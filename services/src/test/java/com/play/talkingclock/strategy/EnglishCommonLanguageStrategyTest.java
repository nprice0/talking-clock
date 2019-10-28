package com.play.talkingclock.strategy;

import com.play.talkingclock.strategy.commonlanguage.CommonLanguageStrategy;
import com.play.talkingclock.strategy.commonlanguage.languages.English;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class EnglishCommonLanguageStrategyTest {

    @Test
    public void testAnteMeridiem() {

        TimeStrategy englishCommonLanguageStrategy = new CommonLanguageStrategy(new English());

        LocalTime localTime = LocalTime.of(0, 0);
        assertEquals("twelve o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(11, 0);
        assertEquals("eleven o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

    }


    @Test
    public void testPostMeridiem() {

        TimeStrategy englishCommonLanguageStrategy = new CommonLanguageStrategy(new English());

        LocalTime localTime = LocalTime.of(12, 0);
        assertEquals("twelve o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(23, 0);
        assertEquals("eleven o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

    }


    @Test
    public void testMinutes() {

        TimeStrategy englishCommonLanguageStrategy = new CommonLanguageStrategy(new English());

        LocalTime localTime = LocalTime.of(0, 0);
        assertEquals("twelve o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 1);
        assertEquals("one past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 2);
        assertEquals("two past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 3);
        assertEquals("three past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 4);
        assertEquals("four past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 5);
        assertEquals("five past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 6);
        assertEquals("six past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 7);
        assertEquals("seven past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 8);
        assertEquals("eight past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 9);
        assertEquals("nine past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 10);
        assertEquals("ten past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 11);
        assertEquals("eleven past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 12);
        assertEquals("twelve past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 13);
        assertEquals("thirteen past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 14);
        assertEquals("fourteen past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 15);
        assertEquals("quarter past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 16);
        assertEquals("sixteen past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 17);
        assertEquals("seventeen past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 18);
        assertEquals("eighteen past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 19);
        assertEquals("nineteen past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 20);
        assertEquals("twenty past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 21);
        assertEquals("twenty one past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 22);
        assertEquals("twenty two past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 23);
        assertEquals("twenty three past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 24);
        assertEquals("twenty four past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 25);
        assertEquals("twenty five past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 26);
        assertEquals("twenty six past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 27);
        assertEquals("twenty seven past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 28);
        assertEquals("twenty eight past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 29);
        assertEquals("twenty nine past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 30);
        assertEquals("half past twelve", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 31);
        assertEquals("twenty nine to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 32);
        assertEquals("twenty eight to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 33);
        assertEquals("twenty seven to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 34);
        assertEquals("twenty six to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 35);
        assertEquals("twenty five to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 36);
        assertEquals("twenty four to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 37);
        assertEquals("twenty three to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 38);
        assertEquals("twenty two to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 39);
        assertEquals("twenty one to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 40);
        assertEquals("twenty to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 41);
        assertEquals("nineteen to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 42);
        assertEquals("eighteen to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 43);
        assertEquals("seventeen to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 44);
        assertEquals("sixteen to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 45);
        assertEquals("quarter to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 46);
        assertEquals("fourteen to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 47);
        assertEquals("thirteen to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 48);
        assertEquals("twelve to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 49);
        assertEquals("eleven to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 50);
        assertEquals("ten to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 51);
        assertEquals("nine to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 52);
        assertEquals("eight to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 53);
        assertEquals("seven to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 54);
        assertEquals("six to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 55);
        assertEquals("five to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 56);
        assertEquals("four to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 57);
        assertEquals("three to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 58);
        assertEquals("two to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 59);
        assertEquals("one to one", englishCommonLanguageStrategy.getTimeInWords(localTime));

    }


    @Test
    public void testHours() {

        TimeStrategy englishCommonLanguageStrategy = new CommonLanguageStrategy(new English());

        LocalTime localTime = LocalTime.of(0, 0);
        assertEquals("twelve o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(1, 0);
        assertEquals("one o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(2, 0);
        assertEquals("two o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(3, 0);
        assertEquals("three o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(4, 0);
        assertEquals("four o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(5, 0);
        assertEquals("five o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(6, 0);
        assertEquals("six o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(7, 0);
        assertEquals("seven o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(8, 0);
        assertEquals("eight o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(9, 0);
        assertEquals("nine o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(10, 0);
        assertEquals("ten o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(11, 0);
        assertEquals("eleven o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(12, 0);
        assertEquals("twelve o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(13, 0);
        assertEquals("one o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(14, 0);
        assertEquals("two o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(15, 0);
        assertEquals("three o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(16, 0);
        assertEquals("four o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(17, 0);
        assertEquals("five o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(18, 0);
        assertEquals("six o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(19, 0);
        assertEquals("seven o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(20, 0);
        assertEquals("eight o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(21, 0);
        assertEquals("nine o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(22, 0);
        assertEquals("ten o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(23, 0);
        assertEquals("eleven o'clock", englishCommonLanguageStrategy.getTimeInWords(localTime));

    }

}