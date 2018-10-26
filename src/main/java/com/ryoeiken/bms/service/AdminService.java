package com.ryoeiken.bms.service;

import com.ryoeiken.bms.pojo.Admin;
import com.ryoeiken.bms.pojo.User;

import java.util.List;

public interface AdminService {
    Admin queryAdminByUsername(String username);

    void addAdmin(Admin admin);

    List<User> queryUserList();

    void deleteUserByUid(int uid);

    void addUser(User user);

    User queryUserByUid(int uid);

    void updateUser(User user);

    List<User> queryUserByType(String type);

    List<User> queryListByUid(int uid);
}
