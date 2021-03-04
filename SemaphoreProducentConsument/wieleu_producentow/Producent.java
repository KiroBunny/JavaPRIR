
package SemaphoreProducentConsument.wieleu_producentow;
import java.util.concurrent.atomic.AtomicInteger;

public class Producent extends Thread {

    private Magazyn magazyn;
    private static int counter;

    public Producent(Magazyn m) {
        magazyn = m;
    }

    public void run() {
        try {
            while (true) {
                String produkt;
                synchronized (Producent.class) {
                    produkt = "" + counter;
                    counter++;
                } 
                magazyn.add(produkt);
                System.out.println("Wrzuciłem do magazynu: " + produkt);
                Thread.sleep((int) (Math.random() * 10));
            }
        }catch (InterruptedException e){ System.out.println("Koniec wątu Producenta");
        }
    }
}
