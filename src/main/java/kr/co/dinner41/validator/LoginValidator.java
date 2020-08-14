package kr.co.dinner41.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.co.dinner41.command.LoginCommand;

public class LoginValidator implements Validator {
	//private static final String REG_EXP_EMAIL="^[_a-z0-9-\\]+(\\_a-z0-9-]+)*@[a-z0-9]+(\\.[a-z0-9]+)*(\\.[a-z] {2,})$";
	private static final String REG_EXP_PASSWORD="/^.*(?=^.{8,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/\r\n";

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(LoginCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		LoginCommand login=(LoginCommand)target;
		String email=login.getEmail();
		String password=login.getPassword();
		//Pattern p=Pattern.compile(REG_EXP_EMAIL);
		//Matcher m=p.matcher(email);
		if(email==null||email.trim().equals("")) {
			errors.rejectValue("email", "email:required","메일주소가 입력되지 않았습니다.");
		}
		/*
		else if(!m.matches()) {
			errors.rejectValue("email", "email:invalid", "올바르지 않은 메일 주소 형식입니다.");
		}
		
		*/

		if(password==null||password.trim().equals("")) {
			errors.rejectValue("password", "password:required","비밀번호가 입력되지 않았습니다.");
		}
		else if(!Pattern.matches(REG_EXP_PASSWORD, password)) {
			errors.rejectValue("password", "password:invalid", "비밀번호는 특수문자/영문자/숫자 포함의 8-15자를 입력해야합니다.");
		}
	}

}
