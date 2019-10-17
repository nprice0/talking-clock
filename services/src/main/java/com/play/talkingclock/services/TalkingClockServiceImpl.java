package com.play.talkingclock.services;

import com.play.talkingclock.services.TalkingClockService;
import com.play.talkingclock.strategy.EnglishNaturalLanguageStrategy;
import java.time.LocalTime;
import org.springframework.stereotype.Service;

@Service
public class TalkingClockServiceImpl implements TalkingClockService {

    @Override
    public String translateToHumanFriendly(LocalTime localTime) {
        EnglishNaturalLanguageStrategy englishNaturalLanguageStrategy = new EnglishNaturalLanguageStrategy();
        return englishNaturalLanguageStrategy.getTimeInWords(localTime);
    }
}
