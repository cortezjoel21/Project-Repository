package app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import app.dto.UserDto;

@Component
public class LoginValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> classInstance) {
		return classInstance == UserDto.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.loginForm");
	}

}
