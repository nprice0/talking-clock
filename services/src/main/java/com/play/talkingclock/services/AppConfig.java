package com.play.talkingclock.services;

import com.play.talkingclock.strategy.EnglishBasicStrategy;
import com.play.talkingclock.strategy.TimeStrategy;
import com.play.talkingclock.strategy.commonlanguage.languages.American;
import com.play.talkingclock.strategy.commonlanguage.CommonLanguageStrategy;
import com.play.talkingclock.strategy.commonlanguage.languages.English;
import com.play.talkingclock.strategy.commonlanguage.languages.LocaleBased;
import com.play.talkingclock.strategy.commonlanguage.languages.Welsh;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class AppConfig {

    @Bean
    public Map<String, TimeStrategy> timeStrategyMap(){

        TimeStrategy englishCommonLanguageStrategy = new CommonLanguageStrategy(new English());
        TimeStrategy americanCommonLanguageStrategy = new CommonLanguageStrategy(new American());
        TimeStrategy welshCommonLanguageStrategy = new CommonLanguageStrategy(new Welsh());
        TimeStrategy englishBasicStrategy = new EnglishBasicStrategy();

        TimeStrategy frenchLocaleDrivenCommonLanguageStrategy = new CommonLanguageStrategy(new LocaleBased("fr"));

        //Add the strategies to the map
        Map<String, TimeStrategy> strategyMap = new LinkedHashMap<>();

        strategyMap.put(englishCommonLanguageStrategy.getFriendlyStrategyName(), englishCommonLanguageStrategy);
        strategyMap.put(americanCommonLanguageStrategy.getFriendlyStrategyName(), americanCommonLanguageStrategy);
        strategyMap.put(welshCommonLanguageStrategy.getFriendlyStrategyName(), welshCommonLanguageStrategy);
        strategyMap.put(americanCommonLanguageStrategy.getFriendlyStrategyName(), americanCommonLanguageStrategy);

        strategyMap.put("fr", frenchLocaleDrivenCommonLanguageStrategy);

        strategyMap.put(englishBasicStrategy.getFriendlyStrategyName(), englishBasicStrategy);

        return strategyMap;
    }

}
