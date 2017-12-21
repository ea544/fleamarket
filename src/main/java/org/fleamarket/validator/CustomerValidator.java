package org.fleamarket.validator;

import org.fleamarket.domain.Customer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CustomerValidator implements Validator {

	public boolean supports(Class<?> paramClass) {
		return Customer.class.equals(paramClass);
	}

	public void validate(Object obj, Errors error) {
		Customer customer = new Customer();
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "password", "customer.password.empty", "");
	}
}