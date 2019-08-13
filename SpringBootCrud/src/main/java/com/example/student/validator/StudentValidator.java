package com.example.student.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.student.model.Student;

public class StudentValidator implements Validator {
	 public boolean supports(Class<?> paramClass) {
	        return Student.class.equals(paramClass);
	    }
	 
	    public void validate(Object obj, Errors errors) {
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "valid.Name");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "valid.Email");
	    }
	    
	    public static boolean isMobile(String s) {
			Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
			Matcher m = p.matcher(s);
			return (m.find() && m.group().equals(s));
		}
		public static boolean isEmailid(String email) {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
					+ "A-Z]{2,7}$";
			Pattern pat = Pattern.compile(emailRegex);
			if (email == null)
				return false;
			return pat.matcher(email).matches();
		}

}
