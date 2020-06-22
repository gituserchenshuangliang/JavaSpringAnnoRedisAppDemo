package com.spring.service;

import com.spring.entity.Student;

import java.util.ArrayList;

/**
 * @description:服务接口
 * @author: Cherry
 * @time: 2020/6/17 18:56
 */
public interface StudentService {
    Student findOne(int uuid);

    int addStudent(Student student);

    ArrayList<Student> findByClassId(int classId);
}
