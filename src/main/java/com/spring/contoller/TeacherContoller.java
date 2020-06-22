package com.spring.contoller;

import com.spring.entity.Teacher;
import com.spring.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:业务控制器
 * @author: Cherry
 * @time: 2020/6/17 12:01
 */
@RestController
public class TeacherContoller {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/tea/{uuid}")
    public Teacher findOne(@PathVariable("uuid") int uuid){
        return teacherService.findOne(uuid);
    }

    @RequestMapping("/tea")
    public Teacher findOne2(int uuid){
        return teacherService.findOne(uuid);
    }

    @RequestMapping("/tea/add")
    public Teacher addOne(){
        Teacher teacher = new Teacher();
        teacher.setAge(132);
        teacher.setName("熔岩巨兽");
        teacher.setMajor("弓箭");
        teacher.setSalary(4000);
        teacher.setSex("M");
        return teacherService.addTeacher(teacher);
    }

    @RequestMapping("/tea/del/{uuid}")
    public String delOne(@PathVariable("uuid") int uuid){
        int i = teacherService.deleteTeacher(uuid);
        if(i != 1){
            return "Delete Failed !";
        }
        return "Delete Successed!";
    }
}
