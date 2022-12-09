package com.tear.sys.service;

import com.tear.sys.entity.Admin;

public interface AdminService {
    Admin  CheckAdmin(String  cname,String  cpwd);
    void update(Admin admin);
    Admin FindOne(Integer id);
}
