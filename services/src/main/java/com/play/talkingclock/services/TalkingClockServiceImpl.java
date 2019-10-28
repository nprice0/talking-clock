package com.play.talkingclock.services;

import com.play.talkingclock.services.TalkingClockService;
import com.play.talkingclock.strategy.EnglishNaturalLanguageStrategy;
import java.time.LocalTime;
import java.util.Map;
import java.util.Optional;

import com.play.talkingclock.strategy.TimeStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private TimeStrategy getTimeStrategy(String name){
        if (timeStrategyMap.containsKey(name)){
            return timeStrategyMap.get(name);
        }else if (!timeStrategyMap.isEmpty()){
            return timeStrategyMap.entrySet().stream().findFirst().get().getValue();
        }else{
            return null;
        }
    }

}
