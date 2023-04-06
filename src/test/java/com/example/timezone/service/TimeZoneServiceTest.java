package com.example.timezone.service;

import com.example.timezone.dto.TimeZoneResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TimeZoneServiceTest {

    @Autowired
    TimeZoneService timeZoneService;
    @MockBean
    private RestTemplate restTemplate;

    private String[] timezoneArr;

    @BeforeEach
    private void setUp() {
        timezoneArr = new String[]{"America/New_York",
                "America/Menominee", "America/Los_Angeles"};
    }

    @Test
    void test_ValidUSTimeZone() {

        Map<String, String> workingOutput = new HashMap<>();
        workingOutput.put("abbreviation", "EDT");
        workingOutput.put("timezone", "America/New_York");
        workingOutput.put("datetime", "2023-04-06T02:05:02.939783+00:00");

        Mockito.when(restTemplate.getForObject(TimeZoneService.URL + "America"
                , String[].class)).thenReturn(timezoneArr);

        Mockito.when(restTemplate.getForObject(TimeZoneService.URL + "America/New_York"
                , Map.class)).thenReturn(workingOutput);

        TimeZoneResponseDTO est = timeZoneService.getTimeZoneInfo("America/New_York");
        assertThat(est).isNotNull();
        assertThat(est.getAbbreviation()).isEqualTo("EDT");
    }

    @Test
    void test_invalid_TimeZone() {

        Mockito.when(restTemplate.getForObject(TimeZoneService.URL + "America"
                , String[].class)).thenReturn(timezoneArr);

        String invalidTimeZone = "ABCD";

        Exception exception = assertThrows(Exception.class, () -> timeZoneService.getTimeZoneInfo(invalidTimeZone));
        assertEquals("Invalid Timezone " + invalidTimeZone, exception.getMessage());
    }
}