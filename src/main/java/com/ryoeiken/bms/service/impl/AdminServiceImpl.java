package com.ryoeiken.bms.service.impl;

import com.ryoeiken.bms.mapper.AdminMapper;
import com.ryoeiken.bms.pojo.Admin;
import com.ryoeiken.bms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin queryAdminByUsername(String username) {
        Admin admin = this.adminMapper.selectByPrimaryKey(username);
        return admin;
    }
}
