package com.example.timezone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TimeZoneResponseDTO {
    private String abbreviation;
    private String timezone;
    private String datetime;
}
