package com.flower.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 19.11.2015.
 */
public class CharacterValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String CHARACTER_PATTERN = "^[_A-Za-z0-9-]{1,18}$";

    public CharacterValidator() {
        pattern = Pattern.compile(CHARACTER_PATTERN);
    }

    public boolean validate(final String password) {
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}