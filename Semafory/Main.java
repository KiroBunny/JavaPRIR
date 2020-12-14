package Semafory;

import java.util.concurrent.Semaphore;

// Watki A i B wykonują się równolegle, wątek C czeka i wykuje się samodzielnie

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore s1 = new Semaphore(0);
        Semaphore s2 = new Semaphore(0);
        Semaphore s3 = new Semaphore(2);

        Thread th1 = new WatekA(s1, s2, s3);
        Thread th2 = new WatekB(s1, s2, s3);
        Thread th3 = new WatekC(s1, s2, s3);
        th1.start();
        th2.start();
        th3.start();

        Thread.sleep(1000);

        th1.interrupt();
        th2.interrupt();
        th3.interrupt();
    }
}

class WatekA extends Thread {
    Semaphore s1;
    Semaphore s2;
    Semaphore s3;

    public WatekA(Semaphore s1, Semaphore s2, Semaphore s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    @Override
    public void run() {
        try{
            while (true){

                s1.acquire();
                System.out.println("== Watek A");
                sleep((int) (Math.random() * 20));
                s3.release();
            }
        } catch (InterruptedException e) {

        }
    }
}

class WatekB extends Thread {
    Semaphore s1;
    Semaphore s2;
    Semaphore s3;

    public WatekB(Semaphore s1, Semaphore s2, Semaphore s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    @Override
    public void run() {
        try{
            while (true){
                s2.acquire();
                System.out.println(" Watek B ==");
                sleep((int) (Math.random() * 20));
                s3.release();
            }
        } catch (InterruptedException e) {

        }
    }
}

class WatekC extends Thread {
    Semaphore s1;
    Semaphore s2;
    Semaphore s3;

    public WatekC(Semaphore s1, Semaphore s2, Semaphore s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    @Override
    public void run() {
        try{
            while (true){
                s3.acquire(2);
                System.out.println("===== Watek CCCC ====");
                sleep((int) (Math.random() * 20));
                s1.release();
                s2.release();
            }
        } catch (InterruptedException e) {

        }
    }
}
