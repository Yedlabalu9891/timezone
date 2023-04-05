package com.example.timezone.controller;


import com.example.timezone.dto.TimeZoneResponseDTO;
import com.example.timezone.service.TimeZoneService;
import com.example.timezone.validation.TimeZoneValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class TimeZoneController {

    @Autowired
    private TimeZoneService service;
    @GetMapping("/time/{timeZone}")
    public ResponseEntity<TimeZoneResponseDTO> getTime(@PathVariable @TimeZoneValidation String timeZone) {
        TimeZoneResponseDTO timeZoneInfo = service.getTimeZoneInfo(timeZone);
        return new ResponseEntity<>(timeZoneInfo, HttpStatus.OK);
    }
}
