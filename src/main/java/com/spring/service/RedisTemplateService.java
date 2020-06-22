package com.spring.service;

/**
 * @description:RedisTemplate流水线服务接口
 * @author: Cherry
 * @time: 2020/6/18 8:33
 */
public interface RedisTemplateService {
    /**
     * 执行多个指令
     */
    void execMultiCommand();

    /**
     * 执行Redis事务
     */
    void execTransaction();

    /**
     * 执行Redis流水线
     */
    void execPipeline();
}
