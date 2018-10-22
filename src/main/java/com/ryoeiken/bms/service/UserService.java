package com.ryoeiken.bms.service;

import com.ryoeiken.bms.pojo.User;

public interface UserService {
    User queryUserByUid(int uid);

    void addUser(User user);
}
