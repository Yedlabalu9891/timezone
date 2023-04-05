package com.example.timezone.service;

import com.example.timezone.dto.TimeZoneResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class TimeZoneServiceTest {

    @InjectMocks
    TimeZoneService timeZoneService;

    @Test
    void test_Working_case() {
        TimeZoneResponseDTO est = timeZoneService.getTimeZoneInfo("EST");
        assertThat(est).isNotNull();
        assertThat(est.getAbbreviation()).isEqualTo("EDT");
    }

    @Test
    void test_invalid_TimeZone() {
        Exception exception = assertThrows(Exception.class, () -> timeZoneService.getTimeZoneInfo("ABCD"));
        assertEquals("Invalid Timezone", exception.getMessage());
    }
}