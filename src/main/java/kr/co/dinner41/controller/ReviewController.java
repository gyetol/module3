package kr.co.dinner41.controller;

import kr.co.dinner41.service.review.ReviewInsertService;
import kr.co.dinner41.service.review.ReviewListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class ReviewController {
    @Autowired
    @Qualifier("reviewInsertService")
    ReviewInsertService insertService;

    @Autowired
    @Qualifier("reviewListService")
    ReviewListService listService;

    @RequestMapping(value = "/gm/review", method = RequestMethod.GET)
    public String insertReview(){
        return "user/reviewInsert";
    }

    @RequestMapping(value = "/gm/review", method = RequestMethod.POST)
    public String insertReview(HttpSession session){

        return "user/reviewInsert";
    }

}
