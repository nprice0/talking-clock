package com.play.talkingclock.services;

import java.time.LocalTime;

public interface TalkingClockService {


    /**
     * Returns a human friendly equivalent of the given time
     *
     * @param localTime
     * @return human friendly equivalent of the time
     */
    public String translateToHumanFriendly(LocalTime localTime, String strategyName);
    
}

