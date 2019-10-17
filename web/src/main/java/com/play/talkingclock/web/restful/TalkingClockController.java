package com.play.talkingclock.web.restful;

import com.play.talkingclock.services.TalkingClockService;
import com.play.talkingclock.io.TimeIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RestController
public class TalkingClockController {

    @Autowired
    TalkingClockService talkingClockService;

    @RequestMapping({"/time/{time}"})
    @ResponseStatus(HttpStatus.OK)
    public TimeIO getTime(@PathVariable(value = "time", required = true) final String time) {

        TimeIO  timeIO = getTimeWithParam(time);
        return timeIO;
    }

    @RequestMapping({"/time", "/time/"})
    @ResponseStatus(HttpStatus.OK)
    public TimeIO getTimeWithParam(@RequestParam(value = "t", required = false) final String time) {

        LocalTime localTime = StringUtils.isEmpty(time) ? LocalTime.now() : LocalTime.parse(time);

        String translatedTime = talkingClockService.translateToHumanFriendly(localTime);

        TimeIO timeIO = new TimeIO();
        timeIO.setHumanFriendlyTime(translatedTime);
        timeIO.setNumericTime(localTime.toString());

        return timeIO;
    }

}