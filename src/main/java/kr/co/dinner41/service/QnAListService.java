package kr.co.dinner41.service;

import kr.co.dinner41.vo.QnAVO;

import java.util.List;

public interface QnAListService {
    List<QnAVO> execute(String qnaType, int page);
}
