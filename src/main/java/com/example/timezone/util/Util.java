package com.example.timezone.util;

import java.util.Map;

public class Util {
    public static final Map<String, String> US_TIMEZONE_MAP;

    static {
        US_TIMEZONE_MAP = Map.of("EST", "America/New_York",
                "CST", "America/Chicago",
                "MST", "America/Denver",
                "PST", "America/Los_Angeles",
                "AST", "America/Anchorage",
                "HST", "America/Adak");
    }
}
