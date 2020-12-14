package watki.zad1i2;

public class MyThread1 implements Runnable {

    Thread t2;

    public void setT2(Thread t2) {
        this.t2 = t2;
    }
    @Override
    public void run() {
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i <= 20; i++)
            System.out.println(i);
    }
}
