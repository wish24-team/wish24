package com.wish.Validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

	public static boolean EmailValidation(String email) {
		String regex = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
		 
		Pattern pattern = Pattern.compile(regex);
		    Matcher matcher = pattern.matcher(email);
		    return matcher.matches();
	}
}
