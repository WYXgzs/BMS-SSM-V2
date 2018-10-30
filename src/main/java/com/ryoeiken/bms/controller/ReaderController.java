package com.ryoeiken.bms.controller;

import com.ryoeiken.bms.pojo.ReaderInfo;
import com.ryoeiken.bms.service.LoginService;
import com.ryoeiken.bms.service.ReaderCardService;
import com.ryoeiken.bms.service.ReaderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping("reader_delete.action")
    public String readerDelete(Integer readerId, RedirectAttributes redirectAttributes) {
        boolean success = this.readerInfoService.deleteReaderInfo(readerId);

        if (success) {
            redirectAttributes.addFlashAttribute("succ", "删除成功！");
            return "redirect:/allreaders.action";
        } else {
            redirectAttributes.addFlashAttribute("error", "删除失败！");
            return "redirect:/allreaders.action";
        }

    }


}
