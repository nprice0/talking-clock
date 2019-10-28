package com.play.talkingclock.strategy.commonlanguage.languages;

import com.play.talkingclock.strategy.commonlanguage.Language;

public class Welsh implements Language {

    private final String[] units = {"", "un", "dau", "tri", "pedwar", "pump", "chwech", "saith", "wyth", "naw", "deg", "undeg un", "undeg dau", "undeg tri", "undeg pedwar", "chwarter", "undeg chwech", "undeg saith", "undeg wyth", "undeg naw"};

    private final String[] tens = {"", "", "ugain", "hanner awr"};

    private final String[] hours = {"deuddeg", "un", "dau", "tri", "pedwar", "pump", "chwech", "saith", "wyth", "naw", "deg", "un ar ddeg"};

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
        return "wedi";
    }

    @Override
    public String getAfterThirty() {
        return "i";
    }

    @Override
    public String getOClock() {
        return "o'r gloch";
    }

    @Override
    public String getMidnight() {
        return "hanner nos";
    }

    @Override
    public String getMidday() {
        return "hanner dydd";
    }
}