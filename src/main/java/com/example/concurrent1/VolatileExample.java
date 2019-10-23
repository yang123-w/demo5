package com.example.concurrent1;

class VolatileExample {
    int x = 0;
    volatile boolean v = false;
    public void writer() {
        x = 42;
        v = true;
    }
    public void reader() {
        if (v == true) {
            // 这里x会是多少呢？
            System.out.println(x);
        }
    }
}
