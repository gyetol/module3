package kr.co.dinner41.service.review;

import kr.co.dinner41.vo.ReviewVO;

import java.util.List;

public interface ReviewListService {
    List<ReviewVO> execute(int storeId, int page);
}
