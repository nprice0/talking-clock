package com.play.talkingclock.strategy.commonlanguage;

public interface Language {

    public String[] getUnits();

    public String[] getTens();

    public String[] getHours();

    public String getBeforeThirty();

    public String getAfterThirty();

    public String getOClock();

}
