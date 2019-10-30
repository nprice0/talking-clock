package com.play.talkingclock.strategy;

import com.play.talkingclock.strategy.commonlanguage.CommonLanguageStrategy;
import com.play.talkingclock.strategy.commonlanguage.languages.LocaleBased;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class LocaleLanguageCommonLanguageStrategyTest {

    @Test
    public void testAnteMeridiem() {

        TimeStrategy welshCommonLanguageStrategy = new CommonLanguageStrategy(new LocaleBased("fr"));

        LocalTime localTime = LocalTime.of(0, 0);
        assertEquals("minuit", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(11, 0);
        assertEquals("onze heures", welshCommonLanguageStrategy.getTimeInWords(localTime));
    }


    @Test
    public void testPostMeridiem() {

        TimeStrategy welshCommonLanguageStrategy = new CommonLanguageStrategy(new LocaleBased("fr"));

        LocalTime localTime = LocalTime.of(12, 0);
        assertEquals("midi", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(23, 0);
        assertEquals("onze heures", welshCommonLanguageStrategy.getTimeInWords(localTime));
    }


    @Test
    public void testMinutes() {

        TimeStrategy welshCommonLanguageStrategy = new CommonLanguageStrategy(new LocaleBased("fr"));

        LocalTime localTime = LocalTime.of(0, 10);
        assertEquals("dix wedi douze", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 15);
        assertEquals("et quart wedi douze", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 30);
        assertEquals("et demie wedi douze", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 40);
        assertEquals("vingt moins un", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(0, 45);
        assertEquals("et quart moins un", welshCommonLanguageStrategy.getTimeInWords(localTime));

    }


    @Test
    public void testHours() {

        TimeStrategy welshCommonLanguageStrategy = new CommonLanguageStrategy(new LocaleBased("fr"));

        LocalTime localTime = LocalTime.of(1, 0);
        assertEquals("un heures", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(2, 0);
        assertEquals("deux heures", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(3, 0);
        assertEquals("trois heures", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(4, 0);
        assertEquals("quatre heures", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(5, 0);
        assertEquals("cinq heures", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(6, 0);
        assertEquals("six heures", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(7, 0);
        assertEquals("sept heures", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(8, 0);
        assertEquals("huit heures", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(9, 0);
        assertEquals("neuf heures", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(10, 0);
        assertEquals("dix heures", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(11, 0);
        assertEquals("onze heures", welshCommonLanguageStrategy.getTimeInWords(localTime));

        localTime = LocalTime.of(12, 0);
        assertEquals("midi", welshCommonLanguageStrategy.getTimeInWords(localTime));

    }

}