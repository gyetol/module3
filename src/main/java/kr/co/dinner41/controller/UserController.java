package kr.co.dinner41.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import kr.co.dinner41.service.user.UserDeleteService;
import kr.co.dinner41.service.user.UserInsertService;
import kr.co.dinner41.service.user.UserUpdateService;
import kr.co.dinner41.service.user.UserViewService;

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
}
