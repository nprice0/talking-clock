package com.play.talkingclock;

import com.play.talkingclock.services.TalkingClockService;
import com.play.talkingclock.web.TalkingClockWebApplication;
import com.play.talkingclock.web.restful.TalkingClockController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TalkingClockWebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ConfigTests {

    @Autowired
    private TalkingClockController talkingClockController;

    @Autowired
    private TalkingClockService talkingClockService;

    @Value("${local.server.port}")
    private int port;

    @Test
    public void getPort() {
        assertThat(port).isEqualTo(9090);
    }

    @Test
    public void contextLoads() throws Exception {
        assertThat(talkingClockController).isNotNull();
        assertThat(talkingClockService).isNotNull();
    }

}
