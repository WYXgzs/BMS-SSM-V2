package com.ryoeiken.bms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {

    //    登录页面
    @RequestMapping("toLogin")
    public String toLogin() {
        return "login";
    }

    //    验证登录
    @RequestMapping("login")
    public String login(Integer uid, String password, HttpSession session) {
        System.out.println(uid);
        System.out.println(password);

        if (uid == 123456 && password.equals("admin")) {
            session.setAttribute("uid", uid);
            return "redirect:/book/list.action";
        } else {
            return "redirect:/user/toLogin.action";
        }
    }
}
