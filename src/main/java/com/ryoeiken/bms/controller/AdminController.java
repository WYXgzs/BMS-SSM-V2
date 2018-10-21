package com.ryoeiken.bms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class AdminController {

    //    http://127.0.0.1/admin/toLogin.action
    @RequestMapping("toLogin")
    public String toLogin() {
        return "admin/login";
    }

    //    http://127.0.0.1/admin/login.action
    @RequestMapping("login")
    public String login(String username, String password, HttpSession session) {
        if (username.equals("admin") && password.equals("admin")) {
            session.setAttribute("username", username);
            return "redirect:/admin/manage.action";
        } else {
            return "redirect:/admin/toLogin.action";
        }
    }

    //    http://127.0.0.1/admin/manage.action
    @RequestMapping("manage")
    public String manage() {
        return "admin/manage";
    }
}
