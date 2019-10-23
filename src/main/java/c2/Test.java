package c2;



public class Test {

    private long count = 0;

    private synchronized void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            count += 1;
        }
    }


    public static void main(String[] args) throws InterruptedException {

        final VolatileExample example = new VolatileExample();
        Thread th1 = new Thread(()->{
            example.reader();
        });

        Thread th2 = new Thread(()->{
            example.reader();
        });

        Thread th3 = new Thread(()->{
            example.reader();
        });
        Thread th4 = new Thread(()->{
            example.reader();
        });
        Thread th5 = new Thread(()->{
            example.reader();
        });
        Thread th6 = new Thread(()->{
            example.reader();
        });

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
        th6.start();
        th1.join();
        th2.join();
        th3.join();
        th4.join();
        th5.join();
        th6.join();

    }
}
