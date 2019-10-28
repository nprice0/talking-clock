package com.play.talkingclock.strategy;

import java.io.Serializable;
import java.time.LocalTime;

public interface TimeStrategy {

    public String getTimeInWords(LocalTime localTime);

    default public String getFriendlyStrategyName(){
        return this.getClass().getSimpleName();
    };
}
