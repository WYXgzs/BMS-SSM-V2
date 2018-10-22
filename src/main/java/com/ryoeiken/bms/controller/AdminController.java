package com.ryoeiken.bms.controller;

import com.ryoeiken.bms.pojo.Admin;
import com.ryoeiken.bms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    //    登录页面
    //    http://127.0.0.1/admin/toLogin.action
    @RequestMapping("toLogin")
    public String toLogin(HttpSession session) {
        Object username = session.getAttribute("username");
        Object uid = session.getAttribute("uid");

        if (uid != null) {
            return "redirect:/user/manage.action";
        }

        if (username != null) {
            return "redirect:/admin/manage.action";
        }
        return "admin/login";
    }

    //    登录判断
    //    http://127.0.0.1/admin/login.action
    @RequestMapping("login")
    public String login(String username, String password, HttpSession session) {
        Admin admin = adminService.queryAdminByUsername(username);

        if (admin != null) {
            String userPassword = admin.getPassword();
            if (password.equals(userPassword)) {
                session.setAttribute("username", username);
                return "redirect:/admin/manage.action";
            } else {
                return "redirect:/admin/toLogin.action";
            }
        } else {
            return "redirect:/admin/toLogin.action";
        }
    }

    //    退出登录
    //    http://127.0.0.1/admin/logout.action
    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:http://127.0.0.1";
    }

    //    管理页面
    //    http://127.0.0.1/admin/manage.action
    @RequestMapping("manage")
    public String manage() {
        return "admin/manage";
    }
}
