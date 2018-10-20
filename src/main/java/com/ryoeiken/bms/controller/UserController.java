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
    @RequestMapping("toLogin")
    public String toLogin(HttpSession session) {

        Object uid = session.getAttribute("uid");
        if (uid != null) {
            return "redirect:/book/list.action";
        }
        return "login";
    }

    //    验证登录
    @RequestMapping("login")
    public String login(int uid, String password, HttpSession session) {

        User user = this.userService.queryUserByUid(uid);

        if (user != null) {
            String userPassword = user.getPassword();
            if (password.equals(userPassword)) {
                session.setAttribute("uid", uid);
                return "redirect:/book/list.action";
            } else {
                return "redirect:/user/toLogin.action";
            }
        } else {
            return "redirect:/user/toLogin.action";
        }

    }

    //    退出登录
    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/user/toLogin.action";
    }
}
