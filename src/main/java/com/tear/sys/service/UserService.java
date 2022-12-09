package com.tear.sys.service;

import com.tear.sys.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
        User  findUserById(int  useri);
        List<User> findAll();
        void delete(int useri);
        User login(String  username,String  password);
        void update(User user);
        void add(User user);
        List<User> findALlByPa(Integer  PageNum,Integer PageSize);

}
