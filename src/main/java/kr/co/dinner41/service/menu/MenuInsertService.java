package kr.co.dinner41.service.menu;

import javax.servlet.http.HttpSession;

import kr.co.dinner41.command.MenuInsertCommand;
import kr.co.dinner41.vo.StoreVO;

public interface MenuInsertService {
	public void execute(MenuInsertCommand command,StoreVO store, HttpSession session);
}
