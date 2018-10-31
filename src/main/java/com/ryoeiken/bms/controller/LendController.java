package com.ryoeiken.bms.controller;

import com.ryoeiken.bms.pojo.LendList;
import com.ryoeiken.bms.pojo.ReaderCard;
import com.ryoeiken.bms.service.BookService;
import com.ryoeiken.bms.service.LendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping("/deletelog.action")
    public String deleteLog(Long sernum, RedirectAttributes redirectAttributes) {
        boolean success = this.lendService.deleteLog(sernum);
        if (success) {
            redirectAttributes.addFlashAttribute("succ", "删除成功！");
            return "redirect:/lendlist.action";
        } else {
            redirectAttributes.addFlashAttribute("error", "删除失败！");
            return "redirect:/lendlist.action";
        }
    }

    @RequestMapping("/querylog.action")
    public String queryLog(Integer searchWord, Model model) {
        boolean exist = this.lendService.matchLog(searchWord);
        if (exist) {
            List<LendList> list = this.lendService.queryLog(searchWord);
            model.addAttribute("list", list);
            return "admin_lend_list";
        } else {
            model.addAttribute("error", "该读者没有借还信息");
            return "admin_lend_list";
        }
    }
}

