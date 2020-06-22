package com.spring.service.impl;

import com.spring.dao.ClassRoomMapper;
import com.spring.entity.ClassRoom;
import com.spring.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:Impl
 * @author: Cherry
 * @time: 2020/6/8 17:14
 */
@Service
public class ClassRoomServiceImpl implements ClassRoomService {
    @Autowired
    ClassRoomMapper classRoomMapper;

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public ClassRoom findByUuid(int uuid) {
        return classRoomMapper.findByUuid(uuid);
    }
}
