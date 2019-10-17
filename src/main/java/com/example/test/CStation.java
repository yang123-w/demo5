package com.example.test;

import java.util.concurrent.CountDownLatch;

public class CStation extends DangerCenter{
    public CStation(CountDownLatch countDownLatch){
        super(countDownLatch,"C-Station");
    }
    @Override
    public void check() {
        System.out.println("checking["+this.getStation()+"]...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("checked["+this.getStation()+"]...");
    }
}

