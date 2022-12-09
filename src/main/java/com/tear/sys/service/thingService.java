package com.tear.sys.service;

import com.tear.sys.entity.thing;

import java.util.List;

public interface thingService {
    //增删改查
    void addThing(thing thing);
    void deleteThing(Integer id );
    void   updateThing(thing thing);
    List<thing> findAll();
    thing  findOne(Integer integer);
    List<thing> findALlByPage(Integer  PageNum,Integer PageSize);
}
