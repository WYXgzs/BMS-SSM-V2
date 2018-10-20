package com.ryoeiken.bms.service;

import com.ryoeiken.bms.pojo.User;

public interface UserService {

    //    查询用户
    User queryUserByUid(int uid);
}
