package org.fleamarket.product.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.fleamarket.product.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		return Product.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors error) {
		Product product = new Product();
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "productName", "product.productName.empty", "");
		// if (!isNumeric(product.getPrice())) {
		// error.rejectValue("price", "product.price.invalid");
		// }
		// if (!isNumeric(product.getQuantity())) {
		// error.rejectValue("quantity", "product.quantity.invalid");
		// }
	}

	public boolean isNumeric(String numeric) {
		String expression = "[0-9]*\\.?[0-9]+";
		CharSequence inputStr = numeric;
		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStr);
		return matcher.matches();
	}
}