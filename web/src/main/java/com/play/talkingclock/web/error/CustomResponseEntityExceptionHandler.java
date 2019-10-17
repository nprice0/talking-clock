package com.play.talkingclock.web.error;

import com.play.talkingclock.io.CustomErrorResponseIO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.DateTimeException;
import java.time.LocalDateTime;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DateTimeException.class)
    public ResponseEntity<CustomErrorResponseIO> customHandleNotFound(Exception ex, WebRequest request)  {

        CustomErrorResponseIO errors = new CustomErrorResponseIO();

        errors.setTimestamp(LocalDateTime.now());
        errors.setMessage(ex.getMessage());
        errors.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        return new ResponseEntity<>(errors, HttpStatus.UNPROCESSABLE_ENTITY);
    }

}