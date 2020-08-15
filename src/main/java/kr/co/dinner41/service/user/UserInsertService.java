package kr.co.dinner41.service.user;

import kr.co.dinner41.command.UserInsertCommand;
import kr.co.dinner41.exception.UserException;

public interface UserInsertService {
	void execute(UserInsertCommand command)throws UserException;
}
