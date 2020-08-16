package kr.co.dinner41.controller;

import kr.co.dinner41.command.QnAAnswerCommand;
import kr.co.dinner41.command.QnAInsertCommand;
import kr.co.dinner41.service.qna.QnAAnswerService;
import kr.co.dinner41.service.qna.QnAInsertService;
import kr.co.dinner41.service.qna.QnAListService;
import kr.co.dinner41.service.qna.QnAViewService;
import kr.co.dinner41.vo.PageVO;
import kr.co.dinner41.vo.QnAVO;
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
    public String insert(HttpSession session){
        UserVO user = (UserVO) session.getAttribute("loginUser");
        System.out.println(user);
        if (user == null){
            return "redirect:/";
        }

        if (user.getType().getId().equals("AD")){
            return "redirect:/ALL/1/qna";
        } else if (user.getType().getId().equals("GM")){
            return "user/qnaWrite";
        } else if (user.getType().getId().equals("SM")){
            return "store/qnaWrite";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/qna", method = RequestMethod.POST)
    public String insert(QnAInsertCommand command, HttpSession session){
        UserVO user = (UserVO) session.getAttribute("loginUser");
        insertService.execute(command, user);
        return "redirect:/ALL/1/qna";
    }

    @RequestMapping(value = "/{type}/{page}/qna", method = RequestMethod.GET)
    public String list(@PathVariable("type") String type, @PathVariable("page") String page
                                            ,HttpSession session, Model model){
        String view_name = "redirect:/";
        int int_page = Integer.parseInt(page);
        List<QnAVO> list = null;
        List<PageVO> pageList = null;

        UserVO user = (UserVO) session.getAttribute("loginUser");
        if (user == null){
            return view_name;
        }

        if (user.getType().getId().equals("AD")){
            list = listService.execute(type, int_page);
            pageList = listService.getPages(int_page, type);
            view_name = "manage/qnaList";
        }else if (user.getType().getId().equals("GM")){
            list = listService.execute(user, type, int_page);
            pageList = listService.getPages(int_page, type, user);
            view_name = "user/qnaList";
        }else if (user.getType().getId().equals("SM")){
            list = listService.execute(user, type, int_page);
            pageList = listService.getPages(int_page, type, user);
            view_name = "store/qnaList";
        }

        model.addAttribute("list", list);
        model.addAttribute("pages", pageList);
        model.addAttribute("type", type);
        model.addAttribute("page", int_page);
        return view_name;
    }

    @RequestMapping(value = "/{id}/qna", method = RequestMethod.GET)
    public String view(@PathVariable("id") String qnaId, HttpSession session,Model model){
        int id = Integer.parseInt(qnaId);
        UserVO user = (UserVO) session.getAttribute("loginUser");
        if (user == null){
            return "redirect:/";
        }

        QnAVO qna = viewService.execute(id);
        model.addAttribute("qna", qna);
        if (user.getType().getId().equals("AD")){
            return "manage/qnaView";
        } else if (user.getType().getId().equals("SM")){
            return "store/qnaView";
        } else if (user.getType().getId().equals("GM")){
            return "user/qnaView";
        } else {
            return "redirect:/ALL/1/qna";
        }
    }

    @RequestMapping(value = "/{id}/qna", method = RequestMethod.POST)
    public String view(@PathVariable("id") String qnaId, QnAAnswerCommand command, HttpSession session){
        int id = Integer.parseInt(qnaId);

        UserVO manager = (UserVO) session.getAttribute("loginUser");
        answerService.execute(manager, id, command);

        return "redirect:/" + qnaId + "/qna";
    }
}
