package com.flower.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 19.11.2015.
 */
public class DigitalValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String DIGITAL_PATTERN = "^[0-9-+]{1,15}$";

    public DigitalValidator() {
        pattern = Pattern.compile(DIGITAL_PATTERN);
    }

    public boolean validate(final String password) {
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}