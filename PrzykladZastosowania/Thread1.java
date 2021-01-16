package PrzykladZastosowania;

import java.util.concurrent.Semaphore;

public class Thread1 extends Thread {
    private Semaphore s1;
    private Semaphore s2;
    private Semaphore s3;

    public Thread1(Semaphore s1, Semaphore s2, Semaphore s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    @Override
    public void run() {
        try {
            while (true) {
                s1.acquire();
                for (int i = 1; i <= 20; i++) {
                    System.out.print(i + ",a ");
                }
                System.out.println();
                s2.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
