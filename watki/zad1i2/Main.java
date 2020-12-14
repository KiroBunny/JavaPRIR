package watki.zad1i2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread1 myt1 = new MyThread1();
        Thread t1 = new Thread(myt1);
        MyThread2 myt2 = new MyThread2();
        Thread t2 = new Thread(myt2);
        myt1.setT2(t2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
