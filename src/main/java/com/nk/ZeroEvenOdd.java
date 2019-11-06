package com.nk;

import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private int num = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (num % 2 != 0) {
                    this.wait();
                }
                printNumber.accept(0);
                num++;
                this.notifyAll();
            }
        }

    }
//    even(printNumber) { ... }  // 仅打印出 偶数
//    odd(printNumber) { ... }   // 仅打印出 奇数
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int j = 2; j <= n; j = j + 2) {
            synchronized (this) {
                while (num % 2 == 0 || num % 4 != 3) {
                    this.wait();
                }
                printNumber.accept(j);
                num++;
                this.notifyAll();
            }
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int j = 1; j <= n; j = j + 2) {
            synchronized (this) {
                while (num % 2 == 0 || num % 4 != 1) {
                    this.wait();
                }
                printNumber.accept(j);
                num++;
                this.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        try {
//            char integer = (char) System.in.read();
//            System.out.println("传入n: " + integer);
//            int input = (char) integer - (char) '0';
            ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
            IntConsumer intConsumer = value -> System.out.println(value);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        zeroEvenOdd.zero(intConsumer);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        zeroEvenOdd.odd(intConsumer);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        zeroEvenOdd.even(intConsumer);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


