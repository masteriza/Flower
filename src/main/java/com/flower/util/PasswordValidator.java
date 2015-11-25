package com.flower.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 19.11.2015.
 */
public class PasswordValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String PASSWORD_PATTERN = "^[_A-Za-z0-9-]{6,18}$";

    public PasswordValidator() {
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }

    public boolean validate(final String password) {
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}