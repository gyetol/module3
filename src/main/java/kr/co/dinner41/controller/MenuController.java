package kr.co.dinner41.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.dinner41.command.MenuInsertCommand;
import kr.co.dinner41.service.menu.MenuDeleteService;
import kr.co.dinner41.service.menu.MenuInsertService;
import kr.co.dinner41.service.menu.MenuListByStoreService;
import kr.co.dinner41.service.menu.MenuListByUserService;
import kr.co.dinner41.service.menu.MenuUpdateAmountService;
import kr.co.dinner41.service.menu.MenuUpdateService;
import kr.co.dinner41.service.menu.MenuViewService;
import kr.co.dinner41.vo.StoreVO;

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
	    public String insert(){
	        return "store/menuRegister";
	    }

	    @RequestMapping(value = "/menu", method = RequestMethod.POST)
	    public String insert(MenuInsertCommand command, StoreVO store, HttpSession session){
	    
	    
	    	
	    	
	    	
	    	return "store/menuList";
	    }


//	    @RequestMapping(value = "", method = RequestMethod.GET)
//	    public String answer(int qnaId, Model model){
//	        return "user/qnaView";
//	    }

//	    @RequestMapping(value = "", method = RequestMethod.POST)
//	    public String answer(int qnaId, HttpSession session, String content){
//	        return "user/qnaView";
//	    }
	}



