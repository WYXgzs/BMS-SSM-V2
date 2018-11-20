package com.ryoeiken.bms.controller;

import com.ryoeiken.bms.pojo.ClassInfo;
import com.ryoeiken.bms.pojo.PageResult;
import com.ryoeiken.bms.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookTypeController {
    @Autowired
    private BookTypeService bookTypeService;

   /* @Autowired
    private LoginService loginService;*/

    @RequestMapping("allBookType.action")
    public String allBookTypes(Model model, @RequestParam(defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "5") Integer pageSize) {
        PageResult<ClassInfo> bookTypes = this.bookTypeService.classInfos(pageNum, pageSize);
        model.addAttribute("bookTypes", bookTypes.getList());

        model.addAttribute("page", bookTypes);
        return "admin_bookType";
    }

    @RequestMapping("bookType_delete.action")
    public String bookTypeDelete(Integer classId, RedirectAttributes redirectAttributes) {
        boolean success = this.bookTypeService.deleteClassInfo(classId);

        if (success) {
            redirectAttributes.addFlashAttribute("succ", "删除成功！");
            return "redirect:/allBookType.action";
        } else {
            redirectAttributes.addFlashAttribute("error", "删除失败！");
            return "redirect:/allBookType.action";
        }
    }

    @RequestMapping("bookType_edit.action")
    public String bookTypeInfoEdit(Integer classId, Model model) {
        ClassInfo classInfo = bookTypeService.getClassInfo(classId);
        model.addAttribute("classInfo", classInfo);
        return "admin_bookType_edit";
    }

    @RequestMapping("bookType_edit_do.action")
    public String BookTypeInfoEditDo(ClassInfo classInfo, RedirectAttributes redirectAttributes) {
        boolean succ = this.bookTypeService.editBookType(classInfo);

        if (succ) {
            redirectAttributes.addFlashAttribute("succ", "读者修改成功！");
            return "redirect:/allBookType.action";
        } else {
            redirectAttributes.addFlashAttribute("error", "读者修改失败！");
            return "redirect:/allBookType.action";
        }
    }

    @RequestMapping("bookType_add.action")
    public String bookTypeInfoAdd() {
        return "admin_bookType_add";
    }

    @RequestMapping("bookType_add_do.action")
    public String BookTypeInfoAddDo(ClassInfo classInfo, RedirectAttributes redirectAttributes) {
        boolean succ = this.bookTypeService.addBookType(classInfo);
        if (succ) {
            redirectAttributes.addFlashAttribute("succ", "读者添加成功！");
            return "redirect:/allBookType.action";
        } else {
            redirectAttributes.addFlashAttribute("succ", "读者添加失败！");
            return "redirect:/allBookType.action";
        }
    }

   /* @RequestMapping("/bookType_info.action")
    public String toBookTypeInfo(HttpSession session, Model model) {
        ReaderCard readerCard = (ReaderCard) session.getAttribute("readercard");
        ReaderInfo readerInfo = this.readerInfoService.getReaderInfo(readerCard.getReaderId());
        model.addAttribute("readerinfo", readerInfo);
        return "reader_info";
    }*/

   /* @RequestMapping("reader_info_edit.action")
    public String readerInfoEditReader(HttpSession session, Model model) {
        ReaderCard readerCard = (ReaderCard) session.getAttribute("readercard");
        ReaderInfo readerInfo = this.readerInfoService.getReaderInfo(readerCard.getReaderId());
        model.addAttribute("readerinfo", readerInfo);
        return "reader_info_edit";

    }

    @RequestMapping("reader_edit_do_r.action")
    public String readerInfoEditDoReader(HttpSession session, ReaderInfo readerInfo, RedirectAttributes redirectAttributes) {
        ReaderCard readerCard = (ReaderCard) session.getAttribute("readercard");
        String name = readerInfo.getName();
        if (!readerCard.getName().equals(name)) {
            boolean succo = this.readerCardService.updateName(readerInfo.getReaderId(), name);

            boolean succ = this.readerInfoService.editReader(readerInfo);
            if (succ && succo) {
                ReaderCard readerCardNew = this.loginService.findReaderCardByUserId(readerCard.getReaderId());
                session.setAttribute("readercard", readerCardNew);
                redirectAttributes.addFlashAttribute("succ", "信息修改成功！");
                return "redirect:/reader_info.action";
            } else {
                redirectAttributes.addFlashAttribute("error", "信息修改失败！");
                return "redirect:/reader_info.action";
            }

        } else {
            boolean succ = this.readerInfoService.editReader(readerInfo);
            if (succ) {
                ReaderCard readerCardNew = this.loginService.findReaderCardByUserId(readerCard.getReaderId());
                session.setAttribute("readercard", readerCardNew);
                redirectAttributes.addFlashAttribute("succ", "信息修改成功！");
                return "redirect:/reader_info.action";
            } else {
                redirectAttributes.addFlashAttribute("error", "信息修改失败！");
                return "redirect:/reader_info.action";
            }
        }

    }

    @RequestMapping("reader_repasswd.action")
    public String readerRePasswd() {
        return "reader_repasswd";
    }

    @RequestMapping("reader_repasswd_do.action")
    public String readerRePasswdDo(HttpSession session, String oldPasswd, String newPasswd, String reNewPasswd,
                                   RedirectAttributes redirectAttributes) {
        ReaderCard readerCard = (ReaderCard) session.getAttribute("readercard");
        int readerId = readerCard.getReaderId();
        String passwd = readerCard.getPasswd();

        if (newPasswd.equals(reNewPasswd)) {
            if (passwd.equals(oldPasswd)) {
                boolean succ = readerCardService.updatePasswd(readerId, newPasswd);
                if (succ) {
                    ReaderCard readerCardNew = this.loginService.findReaderCardByUserId(readerId);
                    session.setAttribute("readercard", readerCardNew);
                    redirectAttributes.addFlashAttribute("succ", "密码修改成功！");
                    return "redirect:/reader_repasswd.action";
                } else {
                    redirectAttributes.addFlashAttribute("succ", "密码修改失败！");
                    return "redirect:/reader_repasswd.action";
                }

            } else {
                redirectAttributes.addFlashAttribute("error", "修改失败,原密码错误");
                return "redirect:/reader_repasswd.action";
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "修改失败,两次输入的新密码不相同");
            return "redirect:/reader_repasswd.action";
        }

    }*/
}
