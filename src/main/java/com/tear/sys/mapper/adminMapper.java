package com.tear.sys.mapper;

import com.tear.sys.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface adminMapper {
    Admin checkAdmin(String cname,String  cpwd);
    void update(Admin admin );
    Admin FindOne(Integer id);
}
