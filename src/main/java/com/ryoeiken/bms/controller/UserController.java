package com.ryoeiken.bms.controller;

import com.ryoeiken.bms.pojo.User;
import com.ryoeiken.bms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    //    登录页面
    //    http://127.0.0.1/user/toLogin.action
    @RequestMapping("toLogin")
    public String toLogin(HttpSession session) {
        Object uid = session.getAttribute("uid");
        Object username = session.getAttribute("username");

        if (username != null) {
            return "redirect:/admin/manage.action";
        }

        if (uid != null) {
            return "redirect:/user/manage.action";
        }
        return "user/login";
    }

    //    登录判断
    //    http://127.0.0.1/user/login.action
    @RequestMapping("login")
    public String login(int uid, String password, HttpSession session) {
        User user = this.userService.queryUserByUid(uid);

        if (user != null) {
            String userPassword = user.getPassword();
            if (password.equals(userPassword)) {
                session.setAttribute("uid", uid);
                return "redirect:/user/manage.action";
            } else {
                return "redirect:/user/toLogin.action";
            }
        } else {
            return "redirect:/user/toLogin.action";
        }
    }

    //    退出登录
    //    http://127.0.0.1/user/logout.action
    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:http://127.0.0.1";
    }

    //    管理页面
    //    http://127.0.0.1/user/manage.action
    @RequestMapping("manage")
    public String manage() {
        return "user/manage";
    }

}
