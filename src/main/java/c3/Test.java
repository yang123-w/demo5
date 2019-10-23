package c3;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Exam exam = new Exam();
        Thread thread = new Thread(()->{
            exam.add();
        });
        Thread thread2 = new Thread(()->{
            exam.add();
        });
        Thread thread3 = new Thread(()->{
            exam.add();
        });
        thread.start();
        thread2.start();
        thread3.start();
        thread.join();
        thread2.join();
        thread3.join();
        System.out.println(exam.x);
    }
}
