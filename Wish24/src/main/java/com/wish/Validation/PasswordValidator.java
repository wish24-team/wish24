package com.wish.Validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author Akash.Kushwah
 * @version 1.0.0.0
 * 
 */
public class PasswordValidator {
 
    private static Pattern pattern;
    private static Matcher matcher;
 
    private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";
 
    public PasswordValidator() {
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }
 
    public static boolean validate(final String password) {
 
        matcher = pattern.matcher(password);
        return matcher.matches();
 
    }
}