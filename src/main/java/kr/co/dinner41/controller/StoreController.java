package kr.co.dinner41.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.dinner41.command.StoreInsertCommand;
import kr.co.dinner41.service.store.StoreInsertService;
import kr.co.dinner41.service.store.StoreListByManagerService;
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
	
	
	
	@Autowired
	@Qualifier("storeListByManagerService")
	StoreListByManagerService storeListByManagerService;
	
	@RequestMapping(value="/sm/store",method=RequestMethod.GET)
	public String insert(HttpSession session) {
		return "store/storeRegister";
	}
	@RequestMapping(value="/sm/store",method=RequestMethod.POST)
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

	@RequestMapping(value="/ad/{store-state-name}/{store-name}/{page}/store",method=RequestMethod.GET)

	public String listByManager(@PathVariable("store-state-name") String storeStateName, @PathVariable("store-name") String storeName, @PathVariable("page") String page, HttpSession session, Model model) {
		int intPage = Integer.parseInt(page);
		List<StoreVO> stores;
		
		UserVO user = (UserVO)session.getAttribute("loginUser");
		
		model.addAttribute("storeStateName",storeStateName);
		model.addAttribute("storeName",storeName);
		model.addAttribute("page",page);

		stores = storeListByManagerService.execute(storeStateName, storeName, intPage);
		
		model.addAttribute("stores",stores);
		
		return "manage/storeList";
	}

	
}
