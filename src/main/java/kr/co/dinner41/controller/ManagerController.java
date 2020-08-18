package kr.co.dinner41.controller;

import kr.co.dinner41.service.manager.ManagerApproveService;
import kr.co.dinner41.service.manager.ManagerBlockService;
import kr.co.dinner41.service.manager.ManagerDeleteService;
import kr.co.dinner41.service.manager.ManagerRejectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ManagerController {
    @Autowired
    @Qualifier("managerApproveService")
    ManagerApproveService approveService;

    @Autowired
    @Qualifier("managerBlockService")
    ManagerBlockService blockService;

    @Autowired
    @Qualifier("managerDeleteService")
    ManagerDeleteService deleteService;

    @Autowired
    @Qualifier("managerRejectService")
    ManagerRejectService rejectService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String approve(){
        return "";
    }

//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public String reject(){
//        return "";
//    }
//
//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public String block(){
//        return "";
//    }
//
//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public String delete(){
//        return "";
//    }
}
