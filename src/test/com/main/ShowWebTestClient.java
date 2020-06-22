package com.main;

import com.spring.config.RootConfig;
import com.spring.contoller.TeacherContoller;
import com.spring.entity.Teacher;
import com.spring.util.LoggerUtil;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * @description:WebTestClient响应流式 Spring WebFlux
 * @author: Cherry
 * @time: 2020/6/21 10:02
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class ShowWebTestClient {

    private Logger logger = LoggerUtil.getLog(ShowWebTestClient.class);
    @Autowired
    private ApplicationContext applicationContext;

    private WebTestClient client;

    @Before
    public void setUp() {
        client = WebTestClient.bindToApplicationContext(applicationContext).build();
        //绑定到运行中的服务器
//        client = WebTestClient.bindToServer().baseUrl("http://localhost:8080").build();
//        client = WebTestClient.bindToController(new TeacherContoller()).configureClient().build();
    }

    @Test
    public void show() {
        client.get().uri("/tea/2")
                //执行请求exchange
                .exchange()
                //声明响应状态和头部
                .expectStatus()
                .isOk()
                //.expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(Teacher.class)
                .consumeWith(s -> logger.info(s));

        client.post().uri("tea/100")
                .exchange()
                .expectStatus().isNotFound().expectBody(Void.class);
    }
}
