package kr.co.dinner41.service.menu;

import javax.servlet.http.HttpSession;

import kr.co.dinner41.command.MenuInsertCommand;
import kr.co.dinner41.vo.StoreVO;
import kr.co.dinner41.vo.UserVO;

public interface MenuInsertService {

	public void execute(MenuInsertCommand menu, StoreVO store, UserVO user);
}
