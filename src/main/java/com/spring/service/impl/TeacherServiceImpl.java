package com.spring.service.impl;

import com.spring.dao.TeacherMapper;
import com.spring.entity.Teacher;
import com.spring.service.TeacherService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @description:服务实现类,使用redis缓存
 * @author: Cherry
 * @time: 2020/6/17 11:56
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    @CachePut(value = "redisCacheManager",key = "'reids_teacher_'+#result.uuid")
    public Teacher addTeacher(Teacher teacher) {
        teacherMapper.addTeacher(teacher);
        return teacher;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    //删除缓存数据
    @CacheEvict(value = "redisCacheManager",key = "'redis_teacher_'+#uuid")
    public int deleteTeacher(int uuid) {
        return teacherMapper.deleteTeacher(uuid);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    @CachePut(value = "redisCacheManager",key = "'reids_teacher_'+#teacher.uuid")
    public int updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    @Cacheable(value = "redisCacheManager",key = "'reids_teacher_'+#uuid")
    public Teacher findOne(int uuid) {
        return teacherMapper.findOne(uuid);
    }

    @Override
    public ArrayList<Teacher> findTeachers(HashMap<String, Object> maps, RowBounds rowBounds) {
        return teacherMapper.findTeachers(maps,rowBounds);
    }

    @Override
    public ArrayList<HashMap<String, Object>> findTeacherField(HashMap<String, Object> maps, int limit, int start) {
        return teacherMapper.findTeacherField(maps,limit,start);
    }

    @Override
    public ArrayList<Teacher> findTeachersByIds(int[] ids) {
        return teacherMapper.findTeachersByIds(ids);
    }
}
