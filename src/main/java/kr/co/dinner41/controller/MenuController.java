package kr.co.dinner41.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.dinner41.command.MenuInsertCommand;
import kr.co.dinner41.command.MenuUpdateCommand;
import kr.co.dinner41.command.UserUpdateCommand;
import kr.co.dinner41.dao.MenuDao;
import kr.co.dinner41.dao.StoreDao;
import kr.co.dinner41.exception.menu.MenuException;
import kr.co.dinner41.exception.user.UserException;
import kr.co.dinner41.service.menu.MenuDeleteService;
import kr.co.dinner41.service.menu.MenuInsertService;
import kr.co.dinner41.service.menu.MenuListByStoreService;
import kr.co.dinner41.service.menu.MenuListByUserService;
import kr.co.dinner41.service.menu.MenuUpdateAmountService;
import kr.co.dinner41.service.menu.MenuUpdateService;
import kr.co.dinner41.service.menu.MenuViewService;
import kr.co.dinner41.service.store.StoreViewByStoreService;
import kr.co.dinner41.vo.MenuVO;
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
       
       @Autowired
       @Qualifier("storeViewByStoreService")
       StoreViewByStoreService storeViewByStoreService;
       
       @Autowired
       @Qualifier("menuDao")
       MenuDao menuDao;
       
       @Autowired
       @Qualifier("storeDao")
       StoreDao storeDao;
       

       @RequestMapping(value = "/sm/menu", method = RequestMethod.GET)
       public String insert(HttpSession session, Model model) throws MenuException {
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

       @RequestMapping(value = "/sm/menu", method = RequestMethod.POST)
       public String insert(MenuInsertCommand menu, Model model, HttpSession session) throws SQLException
       {
          UserVO user = (UserVO)session.getAttribute("loginUser");
          
          insertService.execute(menu, user);
          return "redirect:/sm/1/menu/list";
       }
//          System.out.println("Controller"+user.getName()+", id:"+user.getId());
//          System.out.println(menu.getName());
//          System.out.println(menu.getType());

     
//       if (menu.getName().trim().equals("")) {
//          model.addAttribute("errMessage", "메뉴명이 입력되지 않았습니다.");
//          return "store/menuRegister";
//       }
//       
//       if (menu.getAmount() < 0 || menu.getAmount() == 0) {
//          model.addAttribute("errMessage", "재고 수량은 최소 1개 이상이어야 합니다.");
//          return "store/menuRegister";
//       }
//       
//       if (menu.getPhoto().trim().contentEquals("")) {
//          model.addAttribute("errMessage", "사진은 필수 입력사항입니다.");
//          return "store/menuRegister";
//       }
//       
//       if (menu.getType().trim().contentEquals("")) {
//          model.addAttribute("errMessage", "제공방식은 필수 선택사항입니다.");
//          return "store/menuRegister";
//       }
//       
//       if (menu.getPrice() < 0 || menu.getPrice() == 0) {
//          model.addAttribute("errMessage", "메뉴 가격은 필수 입력사항입니다.");
//          return "store/menuRegister";
//       }
//       
//       if (menu.getTag().trim().contentEquals("")) {
//          model.addAttribute("errMessage", "메뉴 태그는 필수 입력사항입니다.");
//          return "store/menuRegister";
//       }
//       
//       if (menu.getIntroduction().trim().contentEquals("")) {
//          model.addAttribute("errMessage", "메뉴 설명은 필수 입력사항입니다.");
//          return "store/menuRegister";
//       }
//       
//       if (menu.getNotice().trim().contentEquals("")) {
//          model.addAttribute("errMessage", "메뉴 유의사항은 필수 입력사항입니다.");
//          return "store/menuRegister";
//       }
      
       
       @RequestMapping(value = "/sm/{page}/menu/list", method = RequestMethod.GET)
       public String list(@PathVariable("page") int page, Model model, HttpSession session) throws MenuException {
          UserVO user = (UserVO) session.getAttribute("loginUser");
          StoreVO store = storeDao.selectByUserId(user.getId());

          
          List<MenuVO> list = menuDao.selectByStoreId(store.getId(), page, 5);
         
          model.addAttribute("menus", list);
          return "store/menuList";
       }
   
       @RequestMapping(value = "/sm/{storeId}/{menuId}/menu", method = RequestMethod.PUT)
       public String update(@PathVariable("menuId")String menuId, @PathVariable("storeId")String storeId, HttpSession session) throws MenuException {
  
         
          UserVO user = (UserVO) session.getAttribute("loginUser");
    
          if (user.getType().getId().equals("AD")) {
             return "redirect:/";
          }
          else if(user.getType().getId().equals("GM")) {
             return "redirect:/";
          }
          else if(user.getType().getId().equals("SM")) {
             return "redirect:/sm/1/menu/list";
          }
          else {
             return "redirect:/";
          }
       }
     
       
       @RequestMapping(value = "/sm/{storeId}/{menuId}/update/menu", method = RequestMethod.POST)
       public String update(@ModelAttribute("menu") MenuUpdateCommand menu, @PathVariable("menuId")String menuId, @PathVariable("storeId")String storeId, HttpSession session) throws MenuException {
  
    	  int store_id = Integer.parseInt(storeId);
          int menu_id = Integer.parseInt(menuId);
          
          UserVO user = (UserVO)session.getAttribute("loginUser");
          updateService.execute(menu,store_id,menu_id, user);
          return "store/menuModify";
       }
       
       
       @RequestMapping(value = "/sm/{storeId}/{menuId}/menu", method = RequestMethod.POST)
       public String update(@ModelAttribute("command") MenuUpdateCommand command, @PathVariable("menuId")String menuId, @PathVariable("storeId")String storeId, HttpSession session,Model model) throws MenuException {
  
    	  int store_id = Integer.parseInt(storeId);
          int menu_id = Integer.parseInt(menuId);
          
          UserVO user = (UserVO)session.getAttribute("loginUser");
          updateService.execute(command,store_id, menu_id,  user);
          return "redirect:/sm/1/menu/list";
       }
       
       
    
       @RequestMapping(value = "/{storeId}/{menuId}/menu/view", method = RequestMethod.GET)
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
       
       @ResponseBody
      @RequestMapping(value = "/menu/delete", method = RequestMethod.GET)
       public String delete(@RequestParam("storeId") String storeId, @RequestParam("menuId")String menuId, HttpServletRequest request) throws MenuException {
           
              int store_id = Integer.parseInt(storeId);
              int menu_id = Integer.parseInt(menuId);
          
             deleteService.execute(store_id, menu_id);
             return "redirect:/sm/1/menu/list";
             
        }
       
//    @ResponseBody
//   	@RequestMapping(value = "/sm/menu/list", method = RequestMethod.POST)
//   	public HashMap<String, Object> insert(HttpServletRequest request) {
//   		HashMap<String, Object> map = new HashMap<>();
//   		HttpSession session = request.getSession(false);
//   	
//   		UserVO user = (UserVO)session.getAttribute("loginUser");
//   		int userId = user.getId();
//   		
//   		String getTime = request.getParameter("getTime");
//   		
//   		String[] payNumberAndOrderId = insertService.execute(arrForOrder, arrForOrder2, userId, Integer.parseInt(getTime), Integer.parseInt(payTotal));
//   	
//   		String price = arrForOrder[Integer.parseInt(arrForOrder[1])+2];
//
//   		// 결제 진행을 위해 매장결제식별번호, 주문번호, 결제금액, 사용자 정보를 보내줌
//   		map.put("storePayNumber", payNumber);
//   		map.put("orderId", orderId);
//   		map.put("price", price);
//   		map.put("user", user);
//   	
//   		// 결제가 완료되면 완료된 메뉴들을 장바구니에서 제거
//   		int clearMenuCount = Integer.parseInt(arrForOrder[1]);
//   		
//   		System.out.println("결제가 완료된 메뉴의 개수 : " + clearMenuCount);
//   		
//   		String [] clearMenuIds = new String[clearMenuCount]; 
//   		for (int i = 0; i < clearMenuCount; i++) {
//   			clearMenuIds[i] = arrForOrder[i+2];
//   		}
//   		map.put("menuIds", clearMenuIds);
//   		return map;
//   	}
       
      @RequestMapping(value="/sm/{store-name}/{page}/menu/view",method=RequestMethod.GET)
      public String listByStore(@PathVariable("storeId") String storeId,@PathVariable("page") String page, HttpSession session, Model model) throws MenuException {
         int intPage = Integer.parseInt(page);
         int store_id = Integer.parseInt(storeId);
         List<MenuVO> menus;
         
         UserVO user = (UserVO)session.getAttribute("loginUser");
         model.addAttribute("page",page);

         menus = listByStoreService.execute(store_id, intPage);
         
         model.addAttribute("menus",menus);
         
         return "store/menuList";
   }
       
}

