package com.example.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Check {

    private static List<DangerCenter> list;
    private static CountDownLatch countDownLatch;
    private static final int s = 10000;

    public Check(){}

    public static boolean checkAll() throws InterruptedException {

        list=new ArrayList<>();
        countDownLatch=new CountDownLatch(s);
        for (int i = 0; i < s ; i++) {
            list.add(new CStation(countDownLatch));
        }

        Executor executor = Executors.newFixedThreadPool(list.size());

        for (DangerCenter c : list) {
            executor.execute(c);
        }
        countDownLatch.await();
        System.out.println("hhhhhhhhhhhhh");

        for (DangerCenter c : list) {
           if(!c.isOk()){
               return  false;
           }
        }
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        boolean result = Check.checkAll();
        System.out.println(result);
    }
}
