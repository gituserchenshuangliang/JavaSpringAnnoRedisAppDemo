package com.spring.service.impl;

import com.spring.dao.StudentMapper;
import com.spring.entity.Student;
import com.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @description:服务
 * @author: Cherry
 * @time: 2020/6/17 18:57
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public Student findOne(int uuid) {
        return studentMapper.findOne(uuid);
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public ArrayList<Student> findByClassId(int classId) {
        return studentMapper.findByClassId(classId);
    }
}
