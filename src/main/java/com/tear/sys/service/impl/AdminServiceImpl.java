package com.tear.sys.service.impl;

import com.tear.sys.entity.Admin;
import com.tear.sys.mapper.adminMapper;
import com.tear.sys.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    adminMapper  adminMapper;

    @Override
    public Admin CheckAdmin(String cname, String cpwd) {
        return adminMapper.checkAdmin(cname,cpwd);
    }

    @Override
    public Admin FindOne(Integer id) {
        return   adminMapper.FindOne(id);
    }

    @Override
    public void update(Admin admin) {
        adminMapper.update(admin);
    }
}
