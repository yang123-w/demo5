package com.nk;

import java.util.concurrent.Semaphore;

class FooBar {

    Semaphore fooSem = new Semaphore(1);
    Semaphore barSem = new Semaphore(0);
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            fooSem.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barSem.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barSem.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooSem.release();
        }
    }

    public static void main(String[] args) {

        FooBar fooBar = new FooBar(10);

        new Thread(() -> { try { fooBar.foo(new Runnable(){
            @Override
            public void run() {
                System.out.print("foo");
            }
        }); } catch (InterruptedException e) { e.printStackTrace(); } }).start();

        new Thread(() -> { try { fooBar.bar(new Runnable() {
            @Override
            public void run() {
                System.out.println("bar");
            }
        }); } catch (InterruptedException e) { e.printStackTrace(); } }).start();
    }
}
