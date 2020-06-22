package com.spring.web;

import com.spring.config.RedisConfig;
import com.spring.config.RootConfig;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;

/**
 * @description:通过注解初始化Spring MVC替代xml文件
 * @author: Cherry
 * @time: 2020/6/12 9:21
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //配置Spring IoC容器，加载各类Spring Beaan
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class, RedisConfig.class};
    }

    //DispatcherServlet的URI映射关系配置，生成web请求上下文
    @Override
    protected Class<?>[] getServletConfigClasses() {
        //可返回的Java配置文件
        return new Class<?>[]{DispatcherServlet.class};
    }

    //DispatcherServlet拦截的内容
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //配置过滤器
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[]{characterEncodingFilter};
    }

    //Servlet动态加载
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        //文件上传路径
       String filePath = "E:/ServiceDemo";

       //5MB
       long singleMax = (long) (5 * Math.pow(2,20));

       //10MB
        long totalMax = (long) (10 * Math.pow(2,20));

        //配置MultiPartResolver
        registration.setLoadOnStartup(2);

        registration.addMapping("*.html","*.js");
        registration.getMappings().forEach(System.out::println);

        //配置上传
        //registration.setMultipartConfig(new MultipartConfigElement(filePath,singleMax,totalMax,0));
    }

}
