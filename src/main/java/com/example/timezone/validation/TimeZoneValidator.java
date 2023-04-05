package com.example.timezone.validation;

import com.example.timezone.util.Util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Map;

public class TimeZoneValidator implements ConstraintValidator<TimeZoneValidation, String> {
    @Override
    public void initialize(TimeZoneValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String timeZone, ConstraintValidatorContext constraintValidatorContext) {
        Map<String, String> usTimezoneMap = Util.US_TIMEZONE_MAP;
        return usTimezoneMap.containsKey(timeZone);
    }
}
