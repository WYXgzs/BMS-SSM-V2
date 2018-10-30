package com.ryoeiken.bms.controller;

import com.ryoeiken.bms.pojo.ReaderInfo;
import com.ryoeiken.bms.service.LoginService;
import com.ryoeiken.bms.service.ReaderCardService;
import com.ryoeiken.bms.service.ReaderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ReaderController {
    @Autowired
    private ReaderInfoService readerInfoService;

    @Autowired
    private ReaderCardService readerCardService;

    @Autowired
    private LoginService loginService;

    @RequestMapping("allreaders.action")
    public String allBooks(Model model) {
        List<ReaderInfo> readers = this.readerInfoService.readerInfos();
        model.addAttribute("readers", readers);
        return "admin_readers";
    }


}
