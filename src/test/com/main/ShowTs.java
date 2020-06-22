package com.main;

import com.spring.config.RootConfig;
import com.spring.entity.Student;
import com.spring.entity.Teacher;
import com.spring.handler.SexEnum;
import com.spring.service.StudentService;
import com.spring.service.TeacherService;
import com.spring.util.LoggerUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;

/**
 * 演示
 * @author Cherry
 * 2020年5月28日
 */
@WebAppConfiguration//使用Spring MVC则一定要加@WebAppConfiguration注解，否则无法载入web上下文环境
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class ShowTs {
    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;

    @Autowired
    ApplicationContext applicationContext;

    Logger logger = LoggerUtil.getLog(ShowTs.class);

    @Test
    @Commit
    public void addTeacher(){
        Teacher t2 = new Teacher("上官琴",26, "Dance", "F",4500);
        teacherService.addTeacher(t2);
        //生成的主键赋值给t2
        logger.info(t2.getUuid());
    }

    @Test
    @Rollback
    public void deleteTeacher(){
        teacherService.deleteTeacher(19);
    }

    @BeforeTransaction
    public void beforeTransaction(){ }

    @AfterTransaction
    public void afterTransaction(){}

    @Test
    @Sql({"a.sql","/b.sql"})
    @Timed(millis = 1000)
    @Repeat(3)
    public void sqlTs(){}



    @Test
    public void updateTeacher(){
        Teacher t = new Teacher();
        t.setUuid(22);
        t.setName("尉迟洪");
        teacherService.updateTeacher(t);
    }

    @Test
    public void findOne(){
        teacherService.findOne(22);
    }

    @Test
    public void findTeachers(){
        HashMap<String, Object> map = new HashMap<>();
        //Mybatis分页类
        RowBounds row = new RowBounds(1,2);
        map.put("major","c");
        int i = teacherService.findTeachers(map,row).size();
    }

    @Test
    public void findTeacherField(){
        HashMap<String, Object> maps = new HashMap<>();
        teacherService.findTeacherField(maps,3,1);
    }

    @Test
    public void addStu(){
        Student student = new Student();
        student.setName("赵信");
        student.setClassUuid(3);
        student.setSex(SexEnum.MALE);
        studentService.addStudent(student);
        logger.info(student.getUuid());
    }
}
