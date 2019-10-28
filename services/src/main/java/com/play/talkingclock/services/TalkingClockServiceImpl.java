package com.play.talkingclock.services;

import com.play.talkingclock.strategy.TimeStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Map;

@Service
public class TalkingClockServiceImpl implements TalkingClockService {

    @Autowired
    Map<String, TimeStrategy> timeStrategyMap;

    @Override
    public String translateToHumanFriendly(LocalTime localTime, String strategyName) {
        TimeStrategy timeStrategy;

        timeStrategy = getTimeStrategy(strategyName);
        return timeStrategy.getTimeInWords(localTime);
    }


    /**
     * Returns the selected strategy, else the first strategy in the map, or null if empty
     *
     * @param name
     * @return
     */
    private TimeStrategy getTimeStrategy(String name) {
        TimeStrategy timeStrategy = null;

        if (timeStrategyMap != null && !timeStrategyMap.isEmpty()) {

            if (timeStrategyMap.containsKey(name)) {
                timeStrategy = timeStrategyMap.get(name);
            } else if (!timeStrategyMap.isEmpty()) {
                timeStrategy = timeStrategyMap.entrySet().stream().findFirst().get().getValue();
            }
        }
        return timeStrategy;
    }

}
