package kr.co.dinner41.controller;

import kr.co.dinner41.command.QnAInsertCommand;
import kr.co.dinner41.service.qna.QnAAnswerService;
import kr.co.dinner41.service.qna.QnAInsertService;
import kr.co.dinner41.service.qna.QnAListService;
import kr.co.dinner41.service.qna.QnAViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class QnAController {
    @Autowired
    @Qualifier("qnAInsertService")
    QnAInsertService insertService;

    @Autowired
    @Qualifier("qnAViewService")
    QnAViewService viewService;

    @Autowired
    @Qualifier("qnAListService")
    QnAListService listService;

    @Autowired
    @Qualifier("qnAAnswerService")
    QnAAnswerService answerService;

    @RequestMapping(value = "/qna", method = RequestMethod.GET)
    public String insert(){
        return "user/qnaWrite";
    }

    @RequestMapping(value = "/qna", method = RequestMethod.POST)
    public String insert(QnAInsertCommand command, HttpSession session){
        return "user/qnaList";
    }

    @RequestMapping(value = "/{id}/qna", method = RequestMethod.HEAD)
    public String view(@PathVariable("id") String qnaId, Model model){
        int id = Integer.parseInt(qnaId);
        viewService.execute(id);
        return "user/qnaView";
    }

//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public String answer(int qnaId, Model model){
//        return "user/qnaView";
//    }

//    @RequestMapping(value = "", method = RequestMethod.POST)
//    public String answer(int qnaId, HttpSession session, String content){
//        return "user/qnaView";
//    }
}
