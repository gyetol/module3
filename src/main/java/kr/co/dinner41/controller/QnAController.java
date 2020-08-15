package kr.co.dinner41.controller;

import kr.co.dinner41.command.QnAInsertCommand;
import kr.co.dinner41.service.qna.QnAAnswerService;
import kr.co.dinner41.service.qna.QnAInsertService;
import kr.co.dinner41.service.qna.QnAListService;
import kr.co.dinner41.service.qna.QnAViewService;
import kr.co.dinner41.vo.QnAVO;
import kr.co.dinner41.vo.UserTypeVO;
import kr.co.dinner41.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    @RequestMapping(value = "/{type}/{page}/qna", method = RequestMethod.GET)
    public String list(@PathVariable("type") String type, @PathVariable("page") String page
                                            ,HttpSession session, Model model){
        int int_page = Integer.parseInt(page);
        List<QnAVO> list;

        ///
//        session.getAttribute("loginUser");
        UserVO user = new UserVO();
        user.setType(new UserTypeVO("AD", null));
        user.setId(4);
//        현재 세션에 있는 사용자 가지고 오기
        ///

        model.addAttribute("type", type);
        model.addAttribute("page", int_page);
        //사용자에 따른 execute 분기하기
        if (user.getType().getId().equals("AD")){
            list = listService.execute(type, int_page);
            model.addAttribute("list", list);
            return "manage/qnaList";
        }else if (user.getType().getId().equals("GM")){
            list = listService.execute(user, type, int_page);
            model.addAttribute("list", list);
            return "user/qnaList";
        }else if (user.getType().getId().equals("SM")){
            list = listService.execute(user, type, int_page);
            model.addAttribute("list", list);
            return "store/qnaList";
        } else {
            return "common/login";
        }
    }

    @RequestMapping(value = "/{id}/qna", method = RequestMethod.GET)
    public String view(@PathVariable("id") String qnaId, Model model){
        int id = Integer.parseInt(qnaId);
        QnAVO qna = viewService.execute(id);
        model.addAttribute("qna", qna);
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
