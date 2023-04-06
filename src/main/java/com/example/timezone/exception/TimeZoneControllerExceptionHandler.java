package com.example.timezone.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class TimeZoneControllerExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(TimeZoneControllerExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> invalidTimeZone(Exception ex, WebRequest request) {
        logger.error(ex.getMessage(), ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
