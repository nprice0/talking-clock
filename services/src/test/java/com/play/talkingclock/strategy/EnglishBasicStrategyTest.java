package com.play.talkingclock.strategy;

import com.play.talkingclock.strategy.EnglishBasicStrategy;
import com.play.talkingclock.strategy.TimeStrategy;
import org.junit.Test;

import java.time.LocalTime;
import static org.junit.Assert.assertEquals;

public class EnglishBasicStrategyTest {

    @Test
    public void testAnteMeridiem() {

        TimeStrategy englishBasicStrategy = new EnglishBasicStrategy();

        LocalTime localTime = LocalTime.of(0, 0);
        assertEquals("twelve am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(11, 0);
        assertEquals("eleven am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(6, 30);
        assertEquals("six thirty am", englishBasicStrategy.getTimeInWords(localTime));

    }


    @Test
    public void testPostMeridiem() {

        TimeStrategy englishBasicStrategy = new EnglishBasicStrategy();

        LocalTime localTime = LocalTime.of(12, 0);
        assertEquals("twelve pm", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(23, 0);
        assertEquals("eleven pm", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(18, 30);
        assertEquals("six thirty pm", englishBasicStrategy.getTimeInWords(localTime));

    }


    @Test
    public void testMinutes() {

        TimeStrategy englishBasicStrategy = new EnglishBasicStrategy();

        LocalTime localTime = LocalTime.of(0, 0);
        assertEquals("twelve am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 1);
        assertEquals("twelve oh one am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 2);
        assertEquals("twelve oh two am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 3);
        assertEquals("twelve oh three am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 4);
        assertEquals("twelve oh four am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 5);
        assertEquals("twelve oh five am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 6);
        assertEquals("twelve oh six am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 7);
        assertEquals("twelve oh seven am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 8);
        assertEquals("twelve oh eight am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 9);
        assertEquals("twelve oh nine am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 10);
        assertEquals("twelve ten am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 11);
        assertEquals("twelve eleven am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 12);
        assertEquals("twelve twelve am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 13);
        assertEquals("twelve thirteen am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 14);
        assertEquals("twelve fourteen am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 15);
        assertEquals("twelve fifteen am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 16);
        assertEquals("twelve sixteen am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 17);
        assertEquals("twelve seventeen am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 18);
        assertEquals("twelve eighteen am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 19);
        assertEquals("twelve nineteen am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 20);
        assertEquals("twelve twenty am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 21);
        assertEquals("twelve twenty one am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 22);
        assertEquals("twelve twenty two am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 23);
        assertEquals("twelve twenty three am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 24);
        assertEquals("twelve twenty four am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 25);
        assertEquals("twelve twenty five am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 26);
        assertEquals("twelve twenty six am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 27);
        assertEquals("twelve twenty seven am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 28);
        assertEquals("twelve twenty eight am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 29);
        assertEquals("twelve twenty nine am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 30);
        assertEquals("twelve thirty am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 31);
        assertEquals("twelve thirty one am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 32);
        assertEquals("twelve thirty two am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 33);
        assertEquals("twelve thirty three am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 34);
        assertEquals("twelve thirty four am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 35);
        assertEquals("twelve thirty five am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 36);
        assertEquals("twelve thirty six am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 37);
        assertEquals("twelve thirty seven am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 38);
        assertEquals("twelve thirty eight am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 39);
        assertEquals("twelve thirty nine am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 40);
        assertEquals("twelve forty am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 41);
        assertEquals("twelve forty one am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 42);
        assertEquals("twelve forty two am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 43);
        assertEquals("twelve forty three am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 44);
        assertEquals("twelve forty four am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 45);
        assertEquals("twelve forty five am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 46);
        assertEquals("twelve forty six am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 47);
        assertEquals("twelve forty seven am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 48);
        assertEquals("twelve forty eight am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 49);
        assertEquals("twelve forty nine am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 50);
        assertEquals("twelve fifty am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 51);
        assertEquals("twelve fifty one am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 52);
        assertEquals("twelve fifty two am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 53);
        assertEquals("twelve fifty three am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 54);
        assertEquals("twelve fifty four am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 55);
        assertEquals("twelve fifty five am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 56);
        assertEquals("twelve fifty six am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 57);
        assertEquals("twelve fifty seven am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 58);
        assertEquals("twelve fifty eight am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 59);
        assertEquals("twelve fifty nine am", englishBasicStrategy.getTimeInWords(localTime));

    }


    @Test
    public void testHours() {

        TimeStrategy englishBasicStrategy = new EnglishBasicStrategy();

        LocalTime localTime = LocalTime.of(0, 0);
        assertEquals("twelve am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(1, 0);
        assertEquals("one am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(2, 0);
        assertEquals("two am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(3, 0);
        assertEquals("three am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(4, 0);
        assertEquals("four am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(5, 0);
        assertEquals("five am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(6, 0);
        assertEquals("six am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(7, 0);
        assertEquals("seven am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(8, 0);
        assertEquals("eight am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(9, 0);
        assertEquals("nine am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(10, 0);
        assertEquals("ten am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(11, 0);
        assertEquals("eleven am", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(12, 0);
        assertEquals("twelve pm", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(13, 0);
        assertEquals("one pm", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(14, 0);
        assertEquals("two pm", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(15, 0);
        assertEquals("three pm", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(16, 0);
        assertEquals("four pm", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(17, 0);
        assertEquals("five pm", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(18, 0);
        assertEquals("six pm", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(19, 0);
        assertEquals("seven pm", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(20, 0);
        assertEquals("eight pm", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(21, 0);
        assertEquals("nine pm", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(22, 0);
        assertEquals("ten pm", englishBasicStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(23, 0);
        assertEquals("eleven pm", englishBasicStrategy.getTimeInWords(localTime));

    }

}
