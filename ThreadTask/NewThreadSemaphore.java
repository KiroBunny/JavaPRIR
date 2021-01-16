package ThreadTask;

import java.util.concurrent.Semaphore;

public class NewThreadSemaphore extends Thread{
    private int id;

    public NewThreadSemaphore(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println(id);
    }
}
