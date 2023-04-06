package com.example.timezone.controller;


import com.example.timezone.dto.TimeZoneResponseDTO;
import com.example.timezone.service.TimeZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeZoneController {

    @Autowired
    private TimeZoneService timeZoneService;

    @GetMapping("/time")
    public ResponseEntity<TimeZoneResponseDTO> getTimeZoneInfo(@RequestParam String timezone) {

        TimeZoneResponseDTO timeZoneInfo = timeZoneService.getTimeZoneInfo(timezone);
        return new ResponseEntity<>(timeZoneInfo, HttpStatus.OK);

    }
}
