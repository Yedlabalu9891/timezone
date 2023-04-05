package com.example.timezone.exception;

import com.example.timezone.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;
import java.util.Map;


@ControllerAdvice
public class TimeZoneControllerExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(TimeZoneControllerExceptionHandler.class);

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> constraintViolationException(Exception ex, WebRequest request) {

        logger.error(ex.getMessage(), ex);
        StringBuilder message = new StringBuilder("Invalid timezone.")
                .append("Should be one of ");

        Map<String, String> usTimezoneMap = Util.US_TIMEZONE_MAP;

        for (String key : usTimezoneMap.keySet()) {
            message.append(key);
            message.append("\n");
        }

        return new ResponseEntity<>(message.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
