package kr.co.dinner41.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.dinner41.command.MenuInsertCommand;
import kr.co.dinner41.command.MenuUpdateCommand;
import kr.co.dinner41.command.QnAAnswerCommand;
import kr.co.dinner41.service.menu.MenuDeleteService;
import kr.co.dinner41.service.menu.MenuInsertService;
import kr.co.dinner41.service.menu.MenuListByStoreService;
import kr.co.dinner41.service.menu.MenuListByUserService;
import kr.co.dinner41.service.menu.MenuUpdateAmountService;
import kr.co.dinner41.service.menu.MenuUpdateService;
import kr.co.dinner41.service.menu.MenuViewService;
import kr.co.dinner41.vo.MenuVO;
import kr.co.dinner41.vo.QnAVO;
import kr.co.dinner41.vo.StoreVO;
import kr.co.dinner41.vo.UserVO;

@Controller
public class MenuController {
	
	    @Autowired
	    @Qualifier("menuInsertService")
	    MenuInsertService insertService;
	    
	    @Autowired
	    @Qualifier("menuDeleteService")
	    MenuDeleteService deleteService;

	    @Autowired
	    @Qualifier("menuListByUserService")
	    MenuListByUserService listByUserService;

	    @Autowired
	    @Qualifier("menuListByStoreService")
	    MenuListByStoreService listByStoreService;
	    
	    @Autowired
	    @Qualifier("menuUpdateService")
	    MenuUpdateService updateService;
	    
	    @Autowired
	    @Qualifier("menuUpdateAmountService")
	    MenuUpdateAmountService updateAmountService;
	    
	    @Autowired
	    @Qualifier("menuViewService")
	    MenuViewService menuViewService;
	    
	    

	    @RequestMapping(value = "/menu", method = RequestMethod.GET)
	    public String insert(HttpSession session, Model model){
	    	UserVO user = (UserVO) session.getAttribute("loginUser");
	    	
	    	if (user.getType().getId().equals("AD")) {
	    		return "redirect:/";
	    	}
	    	else if(user.getType().getId().equals("GM")) {
	    		return "redirect:/";
	    	}
	    	else if(user.getType().getId().equals("SM")) {
	    		return "store/menuRegister";
	    	}
	    	else {
	    		return "redirect:/";
	    	}
	    }

	    @RequestMapping(value = "/menu", method = RequestMethod.POST)
	    public String insert(MenuInsertCommand menu, Model model, HttpSession session){
	    	UserVO user = (UserVO)session.getAttribute("loginUser");
	    	System.out.println("Controller"+user.getName()+", id:"+user.getId());
	    	System.out.println(menu.getName());
	    	System.out.println(menu.getType());
	    	//int userId=user.getId();
//			StoreVO store =
	    	insertService.execute(menu,user);
	    	
	
	  
//	    if (menu.getName().trim().contentEquals("")) {
//	    	model.addAttribute("errMessage", "메뉴명이 입력되지 않았습니다.");
//	    	return "store/menuRegister";
//	    }
//	    
//	    if (menu.getAmount() < 0 || menu.getAmount() == 0) {
//	    	model.addAttribute("errMessage", "재고 수량은 최소 1개 이상이어야 합니다.");
//	    	return "store/menuRegister";
//	    }
//	    
//	    if (menu.getPhoto().trim().contentEquals("")) {
//	    	model.addAttribute("errMessage", "사진은 필수 입력사항입니다.");
//	    	return "store/menuRegister";
//	    }
//	    
//	    if (menu.getType().trim().contentEquals("")) {
//	    	model.addAttribute("errMessage", "제공방식은 필수 선택사항입니다.");
//	    	return "store/menuRegister";
//	    }
//	    
//	    if (menu.getPrice() < 0 || menu.getPrice() == 0) {
//	    	model.addAttribute("errMessage", "메뉴 가격은 필수 입력사항입니다.");
//	    	return "store/menuRegister";
//	    }
//	    
//	    if (menu.getTag().trim().contentEquals("")) {
//	    	model.addAttribute("errMessage", "메뉴 태그는 필수 입력사항입니다.");
//	    	return "store/menuRegister";
//	    }
//	    
//	    if (menu.getIntroduction().trim().contentEquals("")) {
//	    	model.addAttribute("errMessage", "메뉴 설명은 필수 입력사항입니다.");
//	    	return "store/menuRegister";
//	    }
//	    
//	    if (menu.getNotice().trim().contentEquals("")) {
//	    	model.addAttribute("errMessage", "메뉴 유의사항은 필수 입력사항입니다.");
//	    	return "store/menuRegister";
//	    }
            
    	return "redirect:/";
	   }
	    
	  


	    @RequestMapping(value = "/menu", method = RequestMethod.PUT)
	    public String update(MenuUpdateCommand menu, StoreVO store, HttpSession session){
	    	
	    	UserVO user = (UserVO)session.getAttribute("loginUser");
	    	updateService.execute(menu,store,user);
	        return "store/menuModify";
	    }
	    
	    @RequestMapping(value = "/{storeId}/{menuId}/menu", method = RequestMethod.GET)
	    public String view(@PathVariable("storeId")String storeId, @PathVariable("menuId")String menuId, HttpSession session, Model model){
	    	
	    	 int store_id = Integer.parseInt(storeId);
	    	 int menu_id = Integer.parseInt(menuId);
	    	UserVO user = (UserVO) session.getAttribute("loginUser");
	    	
	    	MenuVO menu = menuViewService.execute(store_id, menu_id);
	    	model.addAttribute("menu",menu);
	    	if (user.getType().getId().equals("AD")) {
	    		return "manage/mangerHome";
	    	}
	    	else if(user.getType().getId().equals("GM")) {
	    		return "user/menuView";
	    	}
	    	else if(user.getType().getId().equals("SM")) {
	    		return "store/menuView";
	    	}
	    	else {
	    		return "redirect:/";
	    	}
	    }
	   
	    
	}



