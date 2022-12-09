package com.tear.sys.mapper;

import com.tear.sys.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    //单修改
    void updateOne(User user);   //只针对于修改用户
    User login(String  username,String  password);//登录
}
