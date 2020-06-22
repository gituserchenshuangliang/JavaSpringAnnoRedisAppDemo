package com.spring.dao;

import com.spring.entity.ClassRoom;
import org.springframework.stereotype.Repository;

/**
 * @description:Mybatsi接口
 * @author: Cherry
 * @time: 2020/6/3 15:25
 */
@Repository
public interface ClassRoomMapper {
    ClassRoom findByUuid(int uuid);
}
