package kr.co.dinner41.service.menu;

import java.util.List;

import kr.co.dinner41.vo.MenuVO;
import kr.co.dinner41.vo.QnAVO;
import kr.co.dinner41.vo.UserVO;

public interface MenuListByStoreService {

	List<MenuVO> execute(UserVO user, int page);
    int getTotalRecord();
    List<Integer> getPages();
}
