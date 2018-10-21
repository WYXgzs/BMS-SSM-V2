package com.ryoeiken.bms.service;

import com.ryoeiken.bms.pojo.Admin;

public interface AdminService {
    Admin queryAdminByUsername(String username);
}
