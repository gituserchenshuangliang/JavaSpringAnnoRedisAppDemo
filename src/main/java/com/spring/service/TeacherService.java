package com.spring.service;

import com.spring.entity.Teacher;
import org.apache.ibatis.session.RowBounds;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @description:服务接口
 * @author: Cherry
 * @time: 2020/6/17 11:55
 */
public interface TeacherService {
    /**
     * JavaBean方式传递参数
     * @param teacher
     * @return
     */
    Teacher addTeacher(Teacher teacher);

    /**
     * 注解方式传递参数
     * @param uuid
     * @return
     */
    int deleteTeacher(int uuid);

    /**
     * JavaBean方式传递参数
     * @param teacher
     * @return
     */
    int updateTeacher(Teacher teacher);

    Teacher findOne(int uuid);

    /**
     * map方式传递参数
     * @param maps
     * @param rowBounds MyBatis 会自动识别它,据此进行分页,它只能运用于一些小数据量的查询。
     * @return
     */
    ArrayList<Teacher> findTeachers(HashMap<String, Object> maps, RowBounds rowBounds);

    /**
     * 混合方式传递参数,无需声明parameterType
     * @param maps
     * @param limit
     * @param start
     * @return
     */
    ArrayList<HashMap<String,Object>> findTeacherField(HashMap<String, Object> maps,int limit, int start);

    /**
     * 出入数组参数
     * @param ids
     * @return
     */
    ArrayList<Teacher> findTeachersByIds(int[] ids);
}
