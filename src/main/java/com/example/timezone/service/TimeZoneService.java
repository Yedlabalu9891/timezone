package com.example.timezone.service;

import com.example.timezone.dto.TimeZoneResponseDTO;
import com.example.timezone.util.Util;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class TimeZoneService {

    public static final String URL = "https://worldtimeapi.org/api/timezone/";

    public TimeZoneResponseDTO getTimeZoneInfo(String name) {
        String zoneName = Util.US_TIMEZONE_MAP.get(name);
        if (zoneName == null) {
            throw new RuntimeException("Invalid Timezone");
        }
        final String uri = URL + zoneName;
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> apiResponse = restTemplate.getForObject(uri, Map.class);
        if (apiResponse != null) {
            String abbreviation = (String) apiResponse.get("abbreviation");
            String timezone = (String) apiResponse.get("timezone");
            String datetime = (String) apiResponse.get("datetime");
            return new TimeZoneResponseDTO(abbreviation, timezone, datetime);
        }
        return null;
    }
}
