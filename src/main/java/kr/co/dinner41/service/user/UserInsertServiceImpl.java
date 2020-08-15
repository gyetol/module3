package kr.co.dinner41.service.user;

import org.springframework.stereotype.Service;

import kr.co.dinner41.command.UserInsertCommand;
import kr.co.dinner41.exception.UserException;

@Service("userInsertService")
public class UserInsertServiceImpl implements UserInsertService {

	@Override
	public void execute(UserInsertCommand command) throws UserException {
		
	}

}
