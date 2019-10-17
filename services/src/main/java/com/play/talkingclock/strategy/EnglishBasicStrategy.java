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
 * 01:00 --> one am
 * 12:30 --> twelve thirty pm
 * 16.05 --> four o' five pm
 * </p>
 */
public class EnglishBasicStrategy implements TimeStrategy, Serializable {

    private static final String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    private static final String[] tens = {"", "", "twenty", "thirty", "forty", "fifty"};

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
        int hour = localTime.getHour() % 12;

        String period = (localTime.getHour() < 12) ? "am" : "pm";

        return buildMessage(getHour(hour), getMinute(minute), period);
    }


    /**
     * Returns the minutes as a word
     *
     * @param minute
     * @return
     */
    private String getMinute(int minute) {
        String ten = tens[(minute / 10)];

        String o = null;
        if (minute > 0 && minute < 10) {
            o = "oh";
        }

        String unit;
        if (minute > 9 && minute < 20) {
            unit = units[minute];
        } else {
            unit = units[minute % 10];
        }

        //Using a stream just to demonstrate, though not the clearest from a readers perspective!
        return buildMessage(o, ten, unit);
    }


    /**
     * Returns the hour as a word
     *
     * @param hour
     * @return
     */
    private String getHour(int hour) {
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