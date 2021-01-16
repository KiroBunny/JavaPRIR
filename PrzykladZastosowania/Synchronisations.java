package PrzykladZastosowania;

class Synchronisations {
    private boolean a = true;
    private boolean b = false;
    private boolean c = false;

    void startA() throws InterruptedException {
        synchronized (this) {
            while (!a) this.wait();
        }
    }

    void startB() throws InterruptedException {
        synchronized (this) {
            while (!b) this.wait();
        }
    }

    void startC() throws InterruptedException {
        synchronized (this) {
            while (!c) this.wait();
        }
    }

    void stopA() {
        synchronized (this) {
            a = false;
            b = true;
            notifyAll();
        }
    }

    void stopB() {
        synchronized (this) {
            b = false;
            c = true;
            notifyAll();
        }
    }

    void stopC() {
        synchronized (this) {
            c = false;
            a = true;
            notifyAll();
        }
    }
}
