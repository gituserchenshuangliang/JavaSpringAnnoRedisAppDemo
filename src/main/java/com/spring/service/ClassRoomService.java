package com.spring.service;

import com.spring.entity.ClassRoom;

/**
 * @description:Service
 * @author: Cherry
 * @time: 2020/6/8 17:12
 */
public interface ClassRoomService {
    ClassRoom findByUuid(int uuid);
}
