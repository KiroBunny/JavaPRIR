package Semafory;

import java.util.concurrent.Semaphore;

public class InnaOpcja3Watki {

        public static void main(String[] args) throws InterruptedException {
            Semaphore s1 = new Semaphore(0, true);
            Semaphore s2 = new Semaphore(2);
//            Semaphore s3 = new Semaphore(2);

            Thread th1 = new Watek1(s1, s2);
            Thread th2 = new Watek2(s1, s2);
            Thread th3 = new Watek3(s1, s2);
            th1.start();
            th2.start();
            th3.start();

            Thread.sleep(1000);

            th1.interrupt();
            th2.interrupt();
            th3.interrupt();
        }
    }

    class Watek1 extends Thread {
        Semaphore s1;
        Semaphore s2;
//        Semaphore s3;

        public Watek1(Semaphore s1, Semaphore s2) {
            this.s1 = s1;
            this.s2 = s2;
//            this.s3 = s3;
        }

        @Override
        public void run() {
            try{
                while (true){

                    s1.acquire();
                    System.out.println("== Watek A");
                    sleep((int) (Math.random() * 20));
                    s2.release();
                }
            } catch (InterruptedException e) {

            }
        }
    }

    class Watek2 extends Thread {
        Semaphore s1;
        Semaphore s2;
//        Semaphore s3;

        public Watek2(Semaphore s1, Semaphore s2) {
            this.s1 = s1;
            this.s2 = s2;
//            this.s3 = s3;
        }

        @Override
        public void run() {
            try{
                while (true){
                    s1.acquire();
                    System.out.println(" Watek B ==");
                    sleep((int) (Math.random() * 20));
                    s2.release();
                }
            } catch (InterruptedException e) {

            }
        }
    }

    class Watek3 extends Thread {
        Semaphore s1;
        Semaphore s2;
//        Semaphore s3;

        public Watek3(Semaphore s1, Semaphore s2) {
            this.s1 = s1;
            this.s2 = s2;
//            this.s3 = s3;
        }

        @Override
        public void run() {
            try{
                while (true){
                    s2.acquire(2);
                    System.out.println("===== Watek CCCC ====");
                    sleep((int) (Math.random() * 20));
                    s1.release(2);
                }
            } catch (InterruptedException e) {

            }
        }
    }

