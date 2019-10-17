package com.play.talkingclock.web.restful;

import com.play.talkingclock.io.CustomErrorResponseIO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class CustomErrorController implements ErrorController {
    private static final String PATH = "/error";
    private static final String DEFAULT_MESSAGE = "There was an unexpected error. No message available";

    @Autowired
    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping(value = PATH)
    CustomErrorResponseIO error(HttpServletRequest request, HttpServletResponse response) {

        Map<String,Object> map = getErrorAttributes(request);

        CustomErrorResponseIO customErrorResponseIO = new CustomErrorResponseIO();

        String message = (String) map.get("message");
        if (StringUtils.isEmpty(message))
            message = DEFAULT_MESSAGE;

        customErrorResponseIO.setMessage(message);

        customErrorResponseIO.setStatus(response.getStatus());
        customErrorResponseIO.setTimestamp(LocalDateTime.now());

        return customErrorResponseIO;
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request) {
        ServletWebRequest requestAttributes = new ServletWebRequest(request);
        return errorAttributes.getErrorAttributes(requestAttributes, false);
    }

}