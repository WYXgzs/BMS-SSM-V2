package com.ryoeiken.bms.service.impl;

import com.ryoeiken.bms.mapper.AdminMapper;
import com.ryoeiken.bms.mapper.UserMapper;
import com.ryoeiken.bms.pojo.Admin;
import com.ryoeiken.bms.pojo.User;
import com.ryoeiken.bms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Admin queryAdminByUsername(String username) {
        Admin admin = this.adminMapper.selectByPrimaryKey(username);
        return admin;
    }

    @Override
    public void addAdmin(Admin admin) {
        this.adminMapper.insert(admin);
    }

    @Override
    public List<User> queryUserList() {
        List<User> list = this.userMapper.selectByExample(null);
        return list;
    }

    @Override
    public void deleteUserByUid(int uid) {
        this.userMapper.deleteByPrimaryKey(uid);
    }
}
