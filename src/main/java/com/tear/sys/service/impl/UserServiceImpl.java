package com.tear.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.tear.sys.entity.User;
import com.tear.sys.mapper.UserMapper;
import com.tear.sys.repository.UserRepository;
import com.tear.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Autowired
    UserMapper userMapper;


    @Override
    public User findUserById(int useri) {
        return userRepository.getById(useri);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findALlByPa(Integer PageNum, Integer PageSize) {
        PageHelper.startPage(PageNum,PageSize)
        ;
        return userRepository.findAll();
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }


    @Override
    public User login(String username, String password) {
        return userMapper.login(username,password);
    }

    @Override
    public void delete(int useri) {
        userRepository.deleteById(useri);
    }



    @Override
    public void add(User user) {
userRepository.save(user);
    }
}
