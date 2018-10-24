package com.ryoeiken.bms.controller;

import com.ryoeiken.bms.pojo.Admin;
import com.ryoeiken.bms.pojo.User;
import com.ryoeiken.bms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    public String login(@RequestParam(value = "username", required = true) String username, String password, HttpSession session) {
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

    //    注册页面
    //    http://127.0.0.1/admin/toRegister.action
    @RequestMapping("toRegister")
    public String toRegister() {
        return "admin/register";
    }

    //    管理员注册
    //    http://127.0.0.1/admin/register.action
    @RequestMapping("register")
    public String register(@RequestParam(value = "username", required = true) String username,
                           @RequestParam(value = "password", required = true) String password,
                           String name, String phone, HttpSession session) {
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        admin.setName(name);
        admin.setPhone(phone);

        this.adminService.addAdmin(admin);
        session.setAttribute("username", username);
        return "redirect:/admin/manage.action";
    }

    //    查询用户列表
    //    http://127.0.0.1/admin/userList.action
    @RequestMapping("userList")
    public String userList(Model model) {
        List<User> list = this.adminService.queryUserList();

        model.addAttribute("userList", list);

        return "admin/userList";
    }

    //    删除单个用户
    //    http://127.0.0.1/admin/userDel.action?uid=${user.uid}
    @RequestMapping("userDel")
    public String userDel(@RequestParam(value = "uid", required = true) int uid) {
        this.adminService.deleteUserByUid(uid);

        return "redirect:/admin/userList.action";
    }

    //    添加单个用户页面
    //    http://127.0.0.1/admin/toAddUser.action
    @RequestMapping("toAddUser")
    public String toAddUser() {
        return "admin/userRegister";
    }

    //    添加单个用户
    //    http://127.0.0.1/admin/addUser.action
    @RequestMapping("addUser")
    public String addUser(@RequestParam(value = "uid", required = true) Integer uid,
                          @RequestParam(value = "password", required = true) String password,
                          String name, String phone, String type) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        User user = new User();
        user.setUid(uid);
        user.setPassword(password);
        user.setName(name);
        user.setPhone(phone);
        user.setType(type);
        user.setCreatetime(sdf.format(date));

        this.adminService.addUser(user);

        return "redirect:/admin/userList.action";
    }
}
