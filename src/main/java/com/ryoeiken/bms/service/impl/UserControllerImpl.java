package com.ryoeiken.bms.service.impl;

import com.ryoeiken.bms.mapper.UserMapper;
import com.ryoeiken.bms.pojo.User;
import com.ryoeiken.bms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserControllerImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserByUid(int uid) {
        User user = this.userMapper.selectByPrimaryKey(uid);
        return user;
    }

    @Override
    public void addUser(User user) {
        this.userMapper.insert(user);
    }
}
