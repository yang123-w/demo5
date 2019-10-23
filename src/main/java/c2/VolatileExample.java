package c2;

class VolatileExample {
    int x = 0;
    boolean v = false;
    public void writer() {
        x = 42;
        v = true;
    }
    public void reader() {
//        if (v == true) {
//            // 这里x会是多少呢？
//            System.out.println("true----"+x++); // volatile 保证：true----:42 不会有true---:0
//        }
        System.out.println("result:"+x++);
    }
}
