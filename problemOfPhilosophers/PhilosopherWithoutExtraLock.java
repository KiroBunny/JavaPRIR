package problemOfPhilosophers;

import java.util.concurrent.Semaphore;

public class PhilosopherWithoutExtraLock extends Thread {
    private Semaphore[] locks;
    private int philosopherID;

    public PhilosopherWithoutExtraLock(Semaphore[] locks, int philosopherID) {
        this.locks = locks;
        this.philosopherID = philosopherID;
    }

    @Override
    public void run() {
        try{
            while (true){
                System.out.println("Mysle " + philosopherID);
                Thread.sleep((long) (7*Math.random()));
                int id1 = philosopherID;
                int id2 = (philosopherID+1) % locks.length;

                int id1sem = Math.min(id1, id2);
                int id2sem = Math.max(id1, id2);


                locks[id1sem].acquireUninterruptibly();
                locks[id2sem].acquireUninterruptibly();

                System.out.println("Zaczyna jesc " + philosopherID);
                Thread.sleep((long)(5*Math.random()));
                System.out.println("Konczy jesc " + philosopherID);

                locks[id1sem].release();
                locks[id2sem].release();
            }
        } catch (InterruptedException ignored) {

        }
    }
}

