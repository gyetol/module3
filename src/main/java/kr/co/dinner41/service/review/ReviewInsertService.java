package kr.co.dinner41.service.review;

import kr.co.dinner41.command.ReviewInsertCommand;
import kr.co.dinner41.vo.ReviewVO;
import kr.co.dinner41.vo.UserVO;

public interface ReviewInsertService {
    void execute(ReviewInsertCommand command, UserVO user);
}
