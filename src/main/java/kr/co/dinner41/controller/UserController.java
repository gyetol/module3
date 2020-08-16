package kr.co.dinner41.controller;

import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.dinner41.command.UserInsertCommand;
import kr.co.dinner41.exception.UserException;
import kr.co.dinner41.service.user.UserDeleteService;
import kr.co.dinner41.service.user.UserInsertService;
import kr.co.dinner41.service.user.UserUpdateService;
import kr.co.dinner41.service.user.UserViewService;
import kr.co.dinner41.validator.UserInsertValidator;
import kr.co.dinner41.vo.UserVO;

@Controller
public class UserController {

	@Autowired
	@Qualifier("userInsertService")
	private UserInsertService insertService;

	@Autowired
	@Qualifier("userViewService")
	private UserViewService viewService;

	@Autowired
	@Qualifier("userDeleteService")
	private UserDeleteService deleteService;

	@Autowired
	@Qualifier("userUpdateService")

	private UserUpdateService updateService;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String insert() {
		return "common/register";
	}

	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String insert(UserInsertCommand command,Errors errors,HttpServletRequest request) {
		/*
		new UserInsertValidator().validate(command,errors);
		if(errors.hasErrors()) {
			return "common/register";
		}
		*/
		System.out.println("insertController진입");
		
		try {
			UserVO user=insertService.execute(command);
			String userType=user.getType().getId();
			HttpSession session=request.getSession();
			session.setAttribute("loginUser", user);
			switch(userType) {
			case "GM":
				return "user/userHome";
			case "AD":
				return "manage/managerHome";
			case "SM":
				return "store/storeHome";
			}
		}catch(UserException e) {
			
		}
		return "common/register";
	}

}
