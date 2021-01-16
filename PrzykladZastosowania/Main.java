package PrzykladZastosowania;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(0);
        Semaphore s3 = new Semaphore(0);

        Synchronisations synch = new Synchronisations();

        Thread1 thread1 = new Thread1(s1, s2, s3);
        Thread2 thread2 = new Thread2(s1, s2, s3);
        Thread3 thread3 = new Thread3(s1, s2, s3);

        ThSynch1 ths1 = new ThSynch1(synch);
        ThSynch2 ths2 = new ThSynch2(synch);
        ThSynch3 ths3 = new ThSynch3(synch);


//        List<Thread> l = Arrays.asList(thread1, thread2, thread3);

      /*  thread1.start();
        thread2.start();
        thread3.start();
  Thread.sleep(1000);
        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();*/

      ths1.start();
      ths2.start();
      ths3.start();

      Thread.sleep(1000);
      ths1.interrupt();
      ths2.interrupt();
      ths3.interrupt();
    }
}
