package kr.co.dinner41.controller;

import kr.co.dinner41.service.review.ReviewInsertService;
import kr.co.dinner41.service.review.ReviewListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ReviewController {
    @Autowired
    @Qualifier("reviewInsertService")
    ReviewInsertService insertService;

    @Autowired
    @Qualifier("reviewListService")
    ReviewListService listService;


}
