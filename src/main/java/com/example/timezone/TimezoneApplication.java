package com.example.timezone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TimezoneApplication {

	/*
	Used the link as reference for the US Timezones
	https://blog.andrewbeacock.com/2006/03/list-of-us-time-zone-ids-for-use-with.html
	 */

    public static void main(String[] args) {
        SpringApplication.run(TimezoneApplication.class, args);
    }

}
