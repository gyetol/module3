package kr.co.dinner41.service.review;

import kr.co.dinner41.vo.ReviewVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("reviewListService")
public class ReviewListServiceImpl implements ReviewListService {
    public static final int PAGE_SIZE = 10;
    @Override
    public List<ReviewVO> execute(int storeId, int page) {
        return null;
    }
}
