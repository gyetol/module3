package kr.co.dinner41.service.qna;

import kr.co.dinner41.command.QnAInsertCommand;
import kr.co.dinner41.vo.UserVO;

public interface QnAInsertService {
    int execute(QnAInsertCommand command, UserVO user);
}
