package com.sn.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Util class to validate user input
 * @author 424969
 *
 */
public class ValidationsUtil {

	/**
	 * Validates whether str contains only number or not.  
	 * @param str
	 * @return true of false
	 */
	 private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
			   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"; 
	 private static Pattern pattern;  
	 private static Matcher matcher;
	public static boolean isValidEmailId(String email){
		boolean result=true;
		pattern = Pattern.compile(EMAIL_PATTERN);  
		   matcher = pattern.matcher(email);  
		   if (!matcher.matches()) {  
		     result=false;
		   }  
		   return result;
		}
}
