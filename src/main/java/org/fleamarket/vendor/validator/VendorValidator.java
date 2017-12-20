package org.fleamarket.vendor.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.fleamarket.vendor.model.Vendor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class VendorValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		return Vendor.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors error) {
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "firstname", "vendor.firstname.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "email", "vendor.email.empty");

		Vendor vendor = (Vendor) obj;
		if (!isValidEmailAddress(vendor.getEmail()))
			error.rejectValue("email", "email.invalid", "vendor.email.invalid");
	}

	public boolean isValidEmailAddress(String emailAddress){ 
		String expression = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	        CharSequence inputStr = emailAddress; 
	        Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE); 
	        Matcher matcher = pattern.matcher(inputStr); 
	        return matcher.matches(); 
	    }
}