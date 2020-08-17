package kr.co.dinner41.service.menu;

import kr.co.dinner41.command.MenuUpdateCommand;
import kr.co.dinner41.exception.menu.MenuException;
import kr.co.dinner41.vo.MenuVO;
import kr.co.dinner41.vo.StoreVO;
import kr.co.dinner41.vo.UserVO;

public interface MenuUpdateService {
	
	void execute(MenuUpdateCommand command, int menuId, int storeId, UserVO user) throws MenuException;

}
