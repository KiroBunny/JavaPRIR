package KoordynacjaWatkow;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        IKoordynator koordynator = new Koordynator();
        WatekA wa = new WatekA(koordynator);
        WatekB wb = new WatekB(koordynator);
        WatekC wc = new WatekC(koordynator);

        wa.start();
        wb.start();
        wc.start();

        wa.join();
        wb.join();
        wc.join();
    }

}

class WatekA extends Thread {
    IKoordynator koordynator;

    public WatekA(IKoordynator koordynator) {
        this.koordynator = koordynator;
    }

    @Override
    public void run() {
        try{
            while (true){
                koordynator.startA();
                System.out.println("== Watek A");
                sleep((int) (Math.random() * 20));
                koordynator.koniecA();
            }
        } catch (InterruptedException e) {

        }
    }
}

class WatekB extends Thread {
    IKoordynator koordynator;

    public WatekB(IKoordynator koordynator) {
        this.koordynator = koordynator;
    }

    @Override
    public void run() {
        try{
            while (true){
                koordynator.startB();
                System.out.println(" Watek B ==");
                sleep((int) (Math.random() * 20));
                koordynator.koniecB();
            }
        } catch (InterruptedException e) {

        }
    }
}

class WatekC extends Thread {
    IKoordynator koordynator;

    public WatekC(IKoordynator koordynator) {
        this.koordynator = koordynator;
    }

    @Override
    public void run() {
        try{
            while (true){
                koordynator.startC();
                System.out.println("===== Watek CCCC ====");
                sleep((int) (Math.random() * 20));
                koordynator.koniecC();
            }
        } catch (InterruptedException e) {

        }
    }
}