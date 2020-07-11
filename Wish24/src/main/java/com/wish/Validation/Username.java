package com.wish.Validation;

import java.util.regex.Pattern;

public class Username {
	public static boolean validateusername(String txt) {

	    String regx = "[a-zA-Z]+\\.?";
	    Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
	     return pattern.matcher(txt).matches();
	    

	}
}
