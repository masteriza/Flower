package com.flower.util;

/**
 * Created by user on 26.10.2015.
 */
public class ClassNameUtil {
    private ClassNameUtil() {
    }

    public static String getCurrentClassName() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            return e.getStackTrace()[1].getClassName();
        }
    }
}
