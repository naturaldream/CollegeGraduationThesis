package com.tear.sys.repository;

import com.tear.sys.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Integer> {
    //继承  实体类  主键类型
}
