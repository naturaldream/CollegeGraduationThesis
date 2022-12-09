package com.tear.sys.repository;

import com.tear.sys.entity.thing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface thingRepository extends JpaRepository<thing,Integer> {
    //jpa CRUD 功能!!!
}
