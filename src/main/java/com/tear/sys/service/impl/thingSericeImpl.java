package com.tear.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.tear.sys.entity.thing;
import com.tear.sys.repository.thingRepository;
import com.tear.sys.service.thingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class thingSericeImpl implements thingService {
    @Autowired
    thingRepository t;

    @Override
    public void addThing(thing thing) {
        t.save(thing);
    }

    @Override
    public List<thing> findALlByPage(Integer PageNum, Integer PageSize) {
        PageHelper.startPage(PageNum,PageSize)
        ;
        return t.findAll();
    }

    @Override
    public void deleteThing(Integer id) {
        t.deleteById(id);
    }

    @Override
    public void updateThing(thing thing) {
t.save(thing);
    }

    @Override
    public List<thing> findAll() {
        return t.findAll();
    }

    @Override
    public thing findOne(Integer integer) {
        return t.getById(integer);
    }
}
