package com.play.talkingclock.strategy.commonlanguage.languages;

import com.play.talkingclock.strategy.commonlanguage.Language;

public class American implements Language {

    private final String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen", "seventeen", "eighteen", "nineteen"};

    private final String[] tens = {"", "", "twenty", "half"};

    private final String[] hours = {"twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven"};

    @Override
    public String[] getUnits() {
        return units;
    }

    @Override
    public String[] getTens() {
        return tens;
    }

    @Override
    public String[] getHours() {
        return hours;
    }

    @Override
    public String getBeforeThirty() {
        return "after";
    }

    @Override
    public String getAfterThirty() {
        return "of";
    }

    @Override
    public String getOClock() {
        return "o'clock";
    }
}