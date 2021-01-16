package PrzykladZastosowania;

import java.util.concurrent.Semaphore;

public class Thread2 extends Thread {
    Semaphore s1;
    Semaphore s2;
    Semaphore s3;

    public Thread2(Semaphore s1, Semaphore s2, Semaphore s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    @Override
    public void run() {
        try {
            while (true) {
                s2.acquire();
                for (int i = 100; i <= 120; i += 2) {
                    System.out.print(i + ",b ");
                }
                System.out.println();
                s3.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
