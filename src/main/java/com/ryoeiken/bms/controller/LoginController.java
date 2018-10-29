package com.ryoeiken.bms.controller;

import com.ryoeiken.bms.pojo.Admin;
import com.ryoeiken.bms.pojo.ReaderCard;
import com.ryoeiken.bms.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    //    登录页面
    @RequestMapping(value = {"/", "/login.action"})
    public String toLogin(HttpServletRequest request) {
        request.getSession().invalidate();
        return "login";
    }

    //    退出登录
    @RequestMapping("/logout.action")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login.action";
    }

    //负责处理loginCheck.html请求
    //请求参数会根据参数名称默认契约自动绑定到相应方法的入参中
    @RequestMapping(value = "loginCheck.action", method = RequestMethod.POST)
    public @ResponseBody
    Object loginCheck(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String passwd = request.getParameter("passwd");
        boolean isReader = this.loginService.hasMatchReader(id, passwd);
        boolean isAdmin = this.loginService.hasMatchAdmin(id, passwd);
        HashMap<String, String> res = new HashMap<String, String>();
        if (isAdmin == false && isReader == false) {
            res.put("stateCode", "0");
            res.put("msg", "账号或密码错误！");
        } else if (isAdmin) {
            Admin admin = new Admin();
            admin.setAdminId(id);
            admin.setPassword(passwd);
            request.getSession().setAttribute("admin", admin);
            res.put("stateCode", "1");
            res.put("msg", "管理员登陆成功！");
        } else {
            ReaderCard readerCard = loginService.findReaderCardByUserId(id);
            request.getSession().setAttribute("readercard", readerCard);
            res.put("stateCode", "2");
            res.put("msg", "读者登陆成功！");
        }
        return res;
    }
}
