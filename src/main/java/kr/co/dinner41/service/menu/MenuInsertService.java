package kr.co.dinner41.service.menu;

import javax.servlet.http.HttpSession;

import kr.co.dinner41.command.MenuInsertCommand;

public interface MenuInsertService {
	public void execute(HttpSession session, MenuInsertCommand command);
}
