package com.play.talkingclock;

import com.play.talkingclock.strategy.EnglishBasicStrategy;
import com.play.talkingclock.strategy.EnglishNaturalLanguageStrategy;
import com.play.talkingclock.strategy.TimeStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class AppConfig {

    @Bean
    public Map<String, TimeStrategy> timeStrategyMap(){

        Map<String, TimeStrategy> strategyMap = new LinkedHashMap<>();

        strategyMap.put(EnglishNaturalLanguageStrategy.class.getSimpleName(),new EnglishNaturalLanguageStrategy());
        strategyMap.put(EnglishBasicStrategy.class.getSimpleName(),new EnglishBasicStrategy());

        return strategyMap;
    }

}
