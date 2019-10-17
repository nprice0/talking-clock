package com.play.talkingclock.strategy;

import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Returns the time in basic English 12 hour clock
 * <p>
 * For example -
 * 01:00 --> one o'clock
 * 12:30 --> half past twelve
 * 16.05 --> five past four
 * </p>
 */
public class EnglishNaturalLanguageStrategy implements TimeStrategy, Serializable {

    private static final String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen", "seventeen", "eighteen", "nineteen"};

    private static final String[] tens = {"", "", "twenty", "half"};

    private static final String[] hours = {"twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven"};


    /**
     * Returns the time as a straight forward english translation
     *
     * @param localTime
     * @return
     */
    @Override
    public String getTimeInWords(LocalTime localTime) {

        int minute = localTime.getMinute();

        if (minute == 0)
            return buildMessage(getHour(localTime), "o'clock");

        else
            return buildMessage(getMinute(minute), getHint(minute), getHour(localTime));
    }


    /**
     * Returns the hint
     *
     * @param minute
     * @return
     */
    private String getHint(int minute) {
        String hint;

        if (minute > 30)
            hint = "to";
        else
            hint = "past";

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