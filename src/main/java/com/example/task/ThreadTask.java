package com.example.task;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class ThreadTask implements Runnable{

//    @Autowired
//    private UserService userService;

    @Override
    public void run() {
//        UserService userService = new UserService();
//        userService.insert();
        System.out.println("aaa");
    }
}
