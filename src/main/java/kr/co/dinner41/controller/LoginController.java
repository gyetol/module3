package kr.co.dinner41.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.dinner41.command.LoginCommand;
import kr.co.dinner41.exception.login.LoginException;
import kr.co.dinner41.service.login.LoginService;
import kr.co.dinner41.validator.LoginValidator;
import kr.co.dinner41.vo.UserVO;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String login() {
		return "common/login";

	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(LoginCommand command,Errors errors,HttpSession session) {
		ModelAndView mav=new ModelAndView();
		new LoginValidator().validate(command, errors);
		if(errors.hasErrors()) {
			mav.setViewName("common/login");
		}
		
		try {
			loginService.execute(command, session);
			mav.addObject("result", "로그인 성공!");
		}catch(LoginException e) {
			mav.addObject("result","로그인 실패"+e.getMessage());
		}
		UserVO user=(UserVO)session.getAttribute("loginUser");
		String userType=user.getType().getId();
		String viewName=null;
		switch(userType) {
		case "GM":
			viewName="user/userHome";
		case "SM":
			viewName="store/storeHome";
		case "AD":
			viewName="manage/managerHome";
		}
		System.out.println(viewName);
		mav.setViewName(viewName);
		return mav;
	}
}
