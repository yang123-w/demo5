package com.example.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestBean {

    /**
     * 使用Configuration和Bean实现ioc对象注入
     * @return
     */
    @Bean
    public User getuser(){
        User user = new User();
        user.setUsername("wwww");
        return user;
    }
}
