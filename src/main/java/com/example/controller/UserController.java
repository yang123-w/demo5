package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import com.example.task.ThreadTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 14:42
 */

@RestController
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable int id){
        return userService.Sel(id).toString();
    }

    @RequestMapping("insert")
    public void  insert(){
        for(int i=0;i<10;i++){
            userService.insert();
        }
    }

    @RequestMapping("thread")
    public void  thread(){
        CountDownLatch countDownLatch = new CountDownLatch(5);
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        long millis = System.currentTimeMillis();
        long l = 0L;
        for (int i = 0; i < 5; i++) {

            threadPool.execute(() -> {
                try {
                    userService.insert();
                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            try {
                countDownLatch.await();
              l = System.currentTimeMillis();
            } catch (InterruptedException e) {
                threadPool.shutdown();
                e.printStackTrace();
            }finally {
                threadPool.shutdown();
                long l1 = millis - l;
                System.out.println("==============>" + l1);
            }
        }


    }


}
