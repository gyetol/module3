package kr.co.dinner41.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.co.dinner41.service.user.UserDeleteService;
import kr.co.dinner41.service.user.UserInsertService;
import kr.co.dinner41.service.user.UserUpdateService;
import kr.co.dinner41.service.user.UserViewService;

@Controller
public class UserController {
	@Autowired
	private UserInsertService insertService;
	@Autowired
	private UserViewService viewService;
	@Autowired
	private UserDeleteService deleteService;
	@Autowired
	private UserUpdateService updateService;

}
