package com.play.talkingclock.strategy;

import com.play.talkingclock.strategy.commonlanguage.CommonLanguageStrategy;
import com.play.talkingclock.strategy.commonlanguage.languages.American;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class AmericanCommonLanguageStrategyTest {

    @Test
    public void testAnteMeridiem() {

        TimeStrategy americanCommonLanguageStrategy = new CommonLanguageStrategy(new American());

        LocalTime localTime = LocalTime.of(0, 0);
        assertEquals("twelve o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(11, 0);
        assertEquals("eleven o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

    }


    @Test
    public void testPostMeridiem() {

        TimeStrategy americanCommonLanguageStrategy = new CommonLanguageStrategy(new American());

        LocalTime localTime = LocalTime.of(12, 0);
        assertEquals("twelve o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(23, 0);
        assertEquals("eleven o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

    }


    @Test
    public void testMinutes() {

        TimeStrategy americanCommonLanguageStrategy = new CommonLanguageStrategy(new American());

        LocalTime localTime = LocalTime.of(0, 0);
        assertEquals("twelve o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 1);
        assertEquals("one after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 2);
        assertEquals("two after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 3);
        assertEquals("three after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 4);
        assertEquals("four after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 5);
        assertEquals("five after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 6);
        assertEquals("six after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 7);
        assertEquals("seven after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 8);
        assertEquals("eight after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 9);
        assertEquals("nine after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 10);
        assertEquals("ten after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 11);
        assertEquals("eleven after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 12);
        assertEquals("twelve after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 13);
        assertEquals("thirteen after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 14);
        assertEquals("fourteen after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 15);
        assertEquals("quarter after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 16);
        assertEquals("sixteen after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 17);
        assertEquals("seventeen after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 18);
        assertEquals("eighteen after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 19);
        assertEquals("nineteen after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 20);
        assertEquals("twenty after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 21);
        assertEquals("twenty one after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 22);
        assertEquals("twenty two after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 23);
        assertEquals("twenty three after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 24);
        assertEquals("twenty four after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 25);
        assertEquals("twenty five after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 26);
        assertEquals("twenty six after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 27);
        assertEquals("twenty seven after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 28);
        assertEquals("twenty eight after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 29);
        assertEquals("twenty nine after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 30);
        assertEquals("half after twelve", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 31);
        assertEquals("twenty nine of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 32);
        assertEquals("twenty eight of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 33);
        assertEquals("twenty seven of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 34);
        assertEquals("twenty six of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 35);
        assertEquals("twenty five of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 36);
        assertEquals("twenty four of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 37);
        assertEquals("twenty three of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 38);
        assertEquals("twenty two of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 39);
        assertEquals("twenty one of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 40);
        assertEquals("twenty of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 41);
        assertEquals("nineteen of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 42);
        assertEquals("eighteen of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 43);
        assertEquals("seventeen of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 44);
        assertEquals("sixteen of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 45);
        assertEquals("quarter of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 46);
        assertEquals("fourteen of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 47);
        assertEquals("thirteen of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 48);
        assertEquals("twelve of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 49);
        assertEquals("eleven of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 50);
        assertEquals("ten of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 51);
        assertEquals("nine of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 52);
        assertEquals("eight of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 53);
        assertEquals("seven of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 54);
        assertEquals("six of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 55);
        assertEquals("five of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 56);
        assertEquals("four of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 57);
        assertEquals("three of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 58);
        assertEquals("two of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 59);
        assertEquals("one of one", americanCommonLanguageStrategy.getTimeInWords(localTime));

    }


    @Test
    public void testHours() {

        TimeStrategy americanCommonLanguageStrategy = new CommonLanguageStrategy(new American());

        LocalTime localTime = LocalTime.of(0, 0);
        assertEquals("twelve o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(1, 0);
        assertEquals("one o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(2, 0);
        assertEquals("two o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(3, 0);
        assertEquals("three o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(4, 0);
        assertEquals("four o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(5, 0);
        assertEquals("five o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(6, 0);
        assertEquals("six o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(7, 0);
        assertEquals("seven o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(8, 0);
        assertEquals("eight o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(9, 0);
        assertEquals("nine o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(10, 0);
        assertEquals("ten o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(11, 0);
        assertEquals("eleven o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(12, 0);
        assertEquals("twelve o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(13, 0);
        assertEquals("one o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(14, 0);
        assertEquals("two o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(15, 0);
        assertEquals("three o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(16, 0);
        assertEquals("four o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(17, 0);
        assertEquals("five o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(18, 0);
        assertEquals("six o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(19, 0);
        assertEquals("seven o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(20, 0);
        assertEquals("eight o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(21, 0);
        assertEquals("nine o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(22, 0);
        assertEquals("ten o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(23, 0);
        assertEquals("eleven o'clock", americanCommonLanguageStrategy.getTimeInWords(localTime));

    }

}
