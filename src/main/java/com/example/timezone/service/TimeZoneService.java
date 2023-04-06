package com.example.timezone.service;

import com.example.timezone.dto.TimeZoneResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class TimeZoneService {

    public static final String URL = "https://worldtimeapi.org/api/timezone/";

    private final RestTemplate restTemplate;

    private List<String> timezoneList;

    public TimeZoneService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        timezoneList = null;
    }

    public TimeZoneResponseDTO getTimeZoneInfo(String name) {

        if (isUsTimezone(name)) {
            final String uri = URL + name;
            Map<String, Object> apiResponse = restTemplate.getForObject(uri, Map.class);
            if (apiResponse != null) {
                String abbreviation = (String) apiResponse.get("abbreviation");
                String timezone = (String) apiResponse.get("timezone");
                String datetime = (String) apiResponse.get("datetime");
                return new TimeZoneResponseDTO(abbreviation, timezone, datetime);
            }
        }
        throw new RuntimeException("Invalid Timezone " + name);

    }

    public List<String> getUSTimezones() {
        if (timezoneList == null) {
            timezoneList = Arrays.asList(restTemplate
                    .getForObject(URL + "America", String[].class));
        }
        return timezoneList;
    }

    public boolean isUsTimezone(final String timezone) {
        List<String> timezones = getUSTimezones();
        return timezones.stream()
                .filter(timezoneArg -> timezone.equals(timezoneArg))
                .count() > 0;
    }
}
