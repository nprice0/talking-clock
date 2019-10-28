package com.play.talkingclock.web;

import com.play.talkingclock.io.CustomErrorResponseIO;
import com.play.talkingclock.io.TimeIO;
import com.play.talkingclock.services.TalkingClockService;
import com.play.talkingclock.strategy.EnglishBasicStrategy;
import com.play.talkingclock.strategy.EnglishNaturalLanguageStrategy;
import com.play.talkingclock.web.restful.TalkingClockController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TalkingClockWebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TalkingClockWebTests {

    private static DateTimeFormatter HOURS_MINUTES = DateTimeFormatter.ofPattern("HH:mm");

    @Autowired
    private TalkingClockController talkingClockController;

    @Autowired
    private TalkingClockService talkingClockService;

    @Value("${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void showsDefaultErrorControllerForInvalidPageRequest() throws Exception {
        //Capture the datetime at the start of the date for comparison in assertion
        LocalDateTime startOfTest = LocalDateTime.now().with(ChronoField.MICRO_OF_SECOND, 0L);

        //Get the data from the response
        URI url = new URI("http://localhost:" + port + "/");
        CustomErrorResponseIO customErrorResponseIO = restTemplate.getForObject(url, CustomErrorResponseIO.class);

        assertThat(customErrorResponseIO.getMessage()).isEqualTo("No message available");
        assertThat(customErrorResponseIO.getStatus()).isEqualTo(404);
        assertThat(customErrorResponseIO.getTimestamp()).isBetween(startOfTest, LocalDateTime.now());
    }


    @Test
    public void handlesInvalidTimeWithPathVariable() throws Exception {

        //Capture the datetime at the start of the date for comparison in assertion
        LocalDateTime startOfTest = LocalDateTime.now().with(ChronoField.MICRO_OF_SECOND, 0L);

        //Set preferred time as convert to LocalTime object. Force the error message to report against the hour.
        String requestedTime = "25:30";

        //Get the data from the response
        URI url = new URI("http://localhost:" + port + "/time/" + requestedTime);
        RequestEntity<CustomErrorResponseIO> requestEntity = new RequestEntity<>(HttpMethod.GET, url);
        ResponseEntity<CustomErrorResponseIO> customErrorResponseIO = restTemplate.exchange(requestEntity, CustomErrorResponseIO.class);

        //Test the http status response code for a 422 and that it alings with reponse body status code
        assertThat(customErrorResponseIO.getStatusCode()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY);
        assertThat(customErrorResponseIO.getStatusCodeValue()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY.value());
        assertThat(customErrorResponseIO.getBody().getStatus()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY.value());

        //Test the response body message text
        assertThat(customErrorResponseIO.getBody().getMessage()).isEqualTo("Text '25:30' could not be parsed: Invalid value for HourOfDay (valid values 0 - 23): 25");

        //Test the response body time
        assertThat(customErrorResponseIO.getBody().getTimestamp()).isBetween(startOfTest, LocalDateTime.now());
    }

    @Test
    public void handlesInvalidTimeWithUrlParameter() throws Exception {

        //Capture the datetime at the start of the date for comparison in assertion
        LocalDateTime startOfTest = LocalDateTime.now().with(ChronoField.MICRO_OF_SECOND, 0L);

        //Set preferred time as convert to LocalTime object.  Force the error message to report against the minute.
        String requestedTime = "23:61";

        //Get the data from the response
        URI url = new URI("http://localhost:" + port + "/time?t=" + requestedTime);
        RequestEntity<CustomErrorResponseIO> requestEntity = new RequestEntity<>(HttpMethod.GET, url);
        ResponseEntity<CustomErrorResponseIO> customErrorResponseIO = restTemplate.exchange(requestEntity, CustomErrorResponseIO.class);

        //Test the http status response code for a 422 and that it alings with reponse body status code
        assertThat(customErrorResponseIO.getStatusCode()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY);
        assertThat(customErrorResponseIO.getStatusCodeValue()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY.value());
        assertThat(customErrorResponseIO.getBody().getStatus()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY.value());

        //Test the response body message text.
        assertThat(customErrorResponseIO.getBody().getMessage()).isEqualTo("Text '23:61' could not be parsed: Invalid value for MinuteOfHour (valid values 0 - 59): 61");

        //Test the response body time
        assertThat(customErrorResponseIO.getBody().getTimestamp()).isBetween(startOfTest, LocalDateTime.now());
    }


    @Test
    public void showsCurrentTimeAsDefault() throws Exception {
        //Capture the datetime at the start of the date for comparison in assertion
        LocalTime startOfTest = LocalTime.now().with(ChronoField.SECOND_OF_MINUTE, 0l).with(ChronoField.MICRO_OF_SECOND, 0l);

        //Get the data from the response
        URI url = new URI("http://localhost:" + port + "/time");
        TimeIO timeIO = restTemplate.getForObject(url, TimeIO.class);

        //Convert the response to a LocalTime
        LocalTime currentTimeFromTimePage = LocalTime.parse(timeIO.getNumericTime(), HOURS_MINUTES);

        assertThat(timeIO.getHumanFriendlyTime()).isEqualTo(talkingClockService.translateToHumanFriendly(currentTimeFromTimePage, null));
        assertThat(currentTimeFromTimePage).isBetween(startOfTest, LocalTime.now());
    }


    @Test
    public void showsRequestedTimeWithPathVariable() throws Exception {

        //Set preferred time as convert to LocalTime object
        String requestedTime = "23:30";
        LocalTime requestedLocalTime = LocalTime.parse(requestedTime, HOURS_MINUTES);

        //Get the data from the response
        URI url = new URI("http://localhost:" + port + "/time/" + requestedTime);
        TimeIO timeIO = restTemplate.getForObject(url, TimeIO.class);

        //Convert the response to a LocalTime
        LocalTime currentTimeFromTimePage = LocalTime.parse(timeIO.getNumericTime(), HOURS_MINUTES);

        assertThat(timeIO.getHumanFriendlyTime()).isEqualTo(talkingClockService.translateToHumanFriendly(currentTimeFromTimePage, null));
        assertThat(currentTimeFromTimePage).isEqualTo(requestedLocalTime);
    }


    @Test
    public void showsRequestedTimeWithUrlParameter() throws Exception {

        //Set preferred time as convert to LocalTime object
        String requestedTime = "00:37";
        LocalTime requestedLocalTime = LocalTime.parse(requestedTime, HOURS_MINUTES);

        //Get the data from the response
        URI url = new URI("http://localhost:" + port + "/time?t=" + requestedTime);
        TimeIO timeIO = restTemplate.getForObject(url, TimeIO.class);

        //Convert the response to a LocalTime
        LocalTime currentTimeFromTimePage = LocalTime.parse(timeIO.getNumericTime(), HOURS_MINUTES);

        assertThat(timeIO.getHumanFriendlyTime()).isEqualTo(talkingClockService.translateToHumanFriendly(currentTimeFromTimePage, null));
        assertThat(currentTimeFromTimePage).isEqualTo(requestedLocalTime);
    }

    @Test
    public void showsEnglishBasicStrategyResult() throws Exception {

        //Set preferred time as convert to LocalTime object
        String requestedTime = "21:45";
        LocalTime requestedLocalTime = LocalTime.parse(requestedTime, HOURS_MINUTES);
        String strategyName = EnglishBasicStrategy.class.getSimpleName();

        //Get the data from the response
        URI url = new URI("http://localhost:" + port + "/time?t=" + requestedTime + "&s=" + strategyName);
        TimeIO timeIO = restTemplate.getForObject(url, TimeIO.class);

        //Convert the response to a LocalTime
        LocalTime currentTimeFromTimePage = LocalTime.parse(timeIO.getNumericTime(), HOURS_MINUTES);

        assertThat(timeIO.getHumanFriendlyTime()).isEqualTo("nine forty five pm");
        assertThat(currentTimeFromTimePage).isEqualTo(requestedLocalTime);
    }

    @Test
    public void showsEnglishNaturalLanguageStrategyResult() throws Exception {

        //Set preferred time as convert to LocalTime object
        String requestedTime = "21:45";
        LocalTime requestedLocalTime = LocalTime.parse(requestedTime, HOURS_MINUTES);
        String strategyName = EnglishNaturalLanguageStrategy.class.getSimpleName();

        //Get the data from the response
        URI url = new URI("http://localhost:" + port + "/time?t=" + requestedTime + "&s=" + strategyName);
        TimeIO timeIO = restTemplate.getForObject(url, TimeIO.class);

        //Convert the response to a LocalTime
        LocalTime currentTimeFromTimePage = LocalTime.parse(timeIO.getNumericTime(), HOURS_MINUTES);

        assertThat(timeIO.getHumanFriendlyTime()).isEqualTo("quarter to ten");
        assertThat(currentTimeFromTimePage).isEqualTo(requestedLocalTime);
    }

}