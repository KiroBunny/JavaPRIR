package problemOfPhilosophers;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {

    private Semaphore[] locks;
    private int philosopherID;
    private Semaphore extraLock;

    public Philosopher(Semaphore[] locks, int philosopherID, Semaphore table) {
        this.locks = locks;
        this.philosopherID = philosopherID;
        this.extraLock = table;
    }

    @Override
    public void run() {
        try{
            while (true){
                System.out.println("Mysle " + philosopherID);
                Thread.sleep((long) (7*Math.random()));

                extraLock.acquireUninterruptibly();
                locks[philosopherID].acquireUninterruptibly();
                locks[(philosopherID+1) % locks.length].acquireUninterruptibly();
                System.out.println("Zaczyna jesc " + philosopherID);
                Thread.sleep((long)(5*Math.random()));
                System.out.println("Konczy jesc " + philosopherID);
                locks[philosopherID].release();
                locks[(philosopherID+1) % locks.length].release();
                extraLock.release();
            }
        } catch (InterruptedException ignored) {

        }
    }
}
