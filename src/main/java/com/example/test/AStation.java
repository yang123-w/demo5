package com.example.test;

import java.util.concurrent.CountDownLatch;

public class AStation extends DangerCenter{
    public AStation(CountDownLatch  countDownLatch){
        super(countDownLatch,"A-Station");
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
