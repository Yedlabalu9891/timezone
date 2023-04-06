package com.example.timezone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TimeZoneResponseDTO {
    private String abbreviation;
    private String timezone;
    private String datetime;
    
     public TimeZoneResponseDTO(String abbreviation, String timezone, String datetime) {
		super();
		this.abbreviation = abbreviation;
		this.timezone = timezone;
		this.datetime = datetime;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getTimezone() {
		return timezone;
}
