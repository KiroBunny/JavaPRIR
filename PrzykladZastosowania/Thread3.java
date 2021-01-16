package PrzykladZastosowania;

import java.util.concurrent.Semaphore;

public class Thread3 extends Thread {
    private Semaphore s1;
    private Semaphore s2;
    private Semaphore s3;

    public Thread3(Semaphore s1, Semaphore s2, Semaphore s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    @Override
    public void run() {

        try {
            int licznik = 0;
            while (true) {
                s3.acquire();
                for (int i = 2; i < 50; i++) {
                        System.out.print(i + ",c ");
                }
                System.out.println("");
                s1.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
