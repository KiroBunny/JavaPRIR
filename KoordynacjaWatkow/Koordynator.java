package KoordynacjaWatkow;

public class Koordynator implements IKoordynator{
    boolean koniecA = false; 
    boolean koniecB = false;

    @Override
    synchronized public void startA() throws InterruptedException {
        while (koniecA ){
            this.wait();
        }
    }

    @Override
    synchronized public void startB() throws InterruptedException {
        while (koniecB ){
            this.wait();
        }
    }

    @Override
    synchronized public void startC() throws InterruptedException {
        while (!(koniecA && koniecB)){ 
            this.wait();
        }
    }

    @Override
    synchronized public void koniecA() {
        koniecA = true;
        notifyAll();
    }

    @Override
    synchronized public void koniecB() {
        koniecB = true;
        notifyAll();
    }

    @Override
    synchronized public void koniecC() throws InterruptedException {
        koniecA = false;
        koniecB = false;
        notifyAll();
    }
}
