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

    private static CountDownLatch countDownLatch;

    @Autowired
    private UserService userService;

    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable int id){
        return userService.Sel(id).toString();
    }

    @RequestMapping("insert")
    public void  insert(){
        long millis = System.currentTimeMillis();
        System.out.println("start==============>" + millis);
        long l = 0L;
        for(int i=1;i<=1000;i++){
            userService.insert();
        }
        l = System.currentTimeMillis();
        long l1 = l - millis;
        System.out.println("end==============>" + l1);
    }

    @RequestMapping("thread")
    public void  thread(){
        countDownLatch = new CountDownLatch(5);
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        long millis = System.currentTimeMillis();
        long l = 0L;
        for (int i = 0; i < 20; i++) {

            threadPool.execute(() -> {
                try {
                    userService.insert();
                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        }

        try {
            countDownLatch.await();
            l = System.currentTimeMillis();
        } catch (InterruptedException e) {
            threadPool.shutdown();
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
            long l1 =l - millis;
            System.out.println("end==============>" + l1);
        }

    }

    @RequestMapping("thread2")
    public void  thread2(){
//        countDownLatch = new CountDownLatch(5);
        ExecutorService threadPool = Executors.newFixedThreadPool(10000);
        long millis = System.currentTimeMillis();
        long l = 0L;
        for (int i = 0; i < 10000; i++) {

            threadPool.execute(() -> {
                try {
                    userService.insert();
//                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        }

        threadPool.shutdown();

        l = System.currentTimeMillis();
        long l1 = l - millis;
        System.out.println("==============>" + l1);
    }


}
