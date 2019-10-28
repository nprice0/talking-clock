package com.play.talkingclock.strategy.commonlanguage;

import com.play.talkingclock.strategy.TimeStrategy;
import org.springframework.util.StringUtils;

import java.time.LocalTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonLanguageStrategy implements TimeStrategy {

    private final String[] units;
    private final String[] tens;
    private final String[] hours;

    private final Language language;

    public CommonLanguageStrategy(Language language) {
        this.language = language;

        this.units = language.getUnits();
        this.tens = language.getTens();
        this.hours = language.getHours();
    }


    /**
     * Returns a friendly name for the strategy
     *
     * @return
     */
    @Override
    public String getFriendlyStrategyName() {
        return language.getClass().getSimpleName() + this.getClass().getSimpleName();
    }


    /**
     * Returns the time as a straight forward english translation
     *
     * @param localTime
     * @return
     */
    @Override
    public String getTimeInWords(LocalTime localTime) {

        String timeAsWords = null;

        int minute = localTime.getMinute();
        int hour = localTime.getHour();

        if (minute == 0) {
            if (hour == 0)
                timeAsWords = language.getMidnight();
            else if (hour == 12)
                timeAsWords = language.getMidday();
            else
                timeAsWords = buildMessage(getHour(localTime), language.getOClock());
        } else
            timeAsWords = buildMessage(getMinute(minute), getUnion(minute), getHour(localTime));

        return timeAsWords;
    }


    /**
     * Returns the hint
     *
     * @param minute
     * @return
     */
    private String getUnion(int minute) {
        String hint;

        if (minute > 30)
            hint = language.getAfterThirty();
        else
            hint = language.getBeforeThirty();

        return hint;
    }


    /**
     * Returns the minutes as a word
     *
     * @param minute
     * @return
     */
    private String getMinute(int minute) {

        if (minute > 30) {
            minute = 60 - minute;
        }

        String ten = tens[(minute / 10)];

        String unit;
        if (minute > 9 && minute < 20) {
            unit = units[minute];
        } else {
            unit = units[minute % 10];
        }

        return buildMessage(ten, unit);
    }


    /**
     * Returns the hour as a word adjusted in accordance to the minute
     *
     * @param localTime
     * @return
     */
    private String getHour(LocalTime localTime) {

        int hour;
        if (localTime.getMinute() > 30)
            hour = localTime.plusHours(1).getHour();
        else
            hour = localTime.getHour();

        return hours[(hour % 12)];
    }

    /**
     * Returns a single space delimited string, resulting from joining each of the input args
     *
     * @param args
     * @return
     */
    public String buildMessage(String... args) {

        return Stream.of(args)
                .filter(s -> !StringUtils.isEmpty(s))
                .collect(Collectors.joining(" "));
    }

}