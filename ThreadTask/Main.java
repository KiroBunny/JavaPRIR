package ThreadTask;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread [] th = new Thread[10];

        for (int i = 0; i<10; i++){
            th[i] = new NewThread(i);
        }

        for (int i = 0; i<10; i++){
            th[i].start();
        }
        sleep(1000);
        for (int i =0; i<10; i++){
          th[i].interrupt();
        }

    }
}
