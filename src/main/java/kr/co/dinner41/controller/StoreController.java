package kr.co.dinner41.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.dinner41.command.StoreInsertCommand;
import kr.co.dinner41.service.store.StoreInsertService;
import kr.co.dinner41.vo.StoreCategoryVO;
import kr.co.dinner41.vo.StoreStateVO;
import kr.co.dinner41.vo.StoreVO;
import kr.co.dinner41.vo.UserVO;

@Controller
@RequestMapping()
public class StoreController {
	@Autowired
	@Qualifier("storeInsertService")
	StoreInsertService storeInsertService;
	
	@RequestMapping(value="/store",method=RequestMethod.GET)
	public String insert(HttpSession session) {
		return "store/storeRegister";
	}
	@RequestMapping(value="/store",method=RequestMethod.POST)
	public String insert(StoreInsertCommand command,Model model,HttpSession session) {
		
		StoreVO store = new StoreVO();
		
		UserVO user = new UserVO();
		user.setId(14);
		
		StoreCategoryVO storeCategory = new StoreCategoryVO();
		storeCategory.setId("KOR");
		
		StoreStateVO storeState = new StoreStateVO();
		storeState.setId(2);
		
		store.setUser(user);
		store.setCategory(storeCategory);
		store.setState(storeState);
		store.setBusinessNumber(command.getBusinessNumber());
		store.setName(command.getName());
		store.setAddress(command.getAddress());
		store.setSubAddress(command.getSubAddress());
		store.setLatitude(37.482417);//store.setLatitude(command.getLatitude());
		store.setLongitude(126.953073);//store.setLongitude(command.getLongitude());
		store.setPhone(command.getPhone());
		store.setOperateTime(command.getOperateTime());
		store.setPhoto(command.getPhoto());
		store.setIntroduction(command.getIntroduction());
	
		storeInsertService.execute(store);
		return "login";
	}
	
}
