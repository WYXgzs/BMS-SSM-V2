package com.ryoeiken.bms.service;

import com.ryoeiken.bms.pojo.Admin;
import com.ryoeiken.bms.pojo.User;

import java.util.List;

public interface AdminService {
    Admin queryAdminByUsername(String username);

    void addAdmin(Admin admin);

    List<User> queryUserList();
}
