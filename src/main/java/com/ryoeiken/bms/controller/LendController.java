package com.ryoeiken.bms.controller;

import com.ryoeiken.bms.pojo.LendList;
import com.ryoeiken.bms.pojo.ReaderCard;
import com.ryoeiken.bms.service.BookService;
import com.ryoeiken.bms.service.LendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LendController {
    @Autowired
    private LendService lendService;

    @Autowired
    private BookService bookService;

    @RequestMapping("/mylend.action")
    public String myLend(HttpSession session, Model model) {
        ReaderCard readerCard = (ReaderCard) session.getAttribute("readercard");
        List<LendList> list = this.lendService.myLendList(readerCard.getReaderId());
        model.addAttribute("list", list);
        return "reader_lend_list";
    }

    @RequestMapping("/lendlist.action")
    public String lendList(Model model) {
        List<LendList> list = this.lendService.lendList();
        model.addAttribute("list", list);
        return "admin_lend_list";
    }
}
