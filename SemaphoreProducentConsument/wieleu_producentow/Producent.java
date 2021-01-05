/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SemaphoreProducentConsument.wieleu_producentow;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Marcin
 */
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
                } //UWAGA tutaj ciągle może dojść do wyścigu ponieważ różne operacja magazyn.add() nie jest synchronizowana, więc inny wątek może dodać wcześniej niż nasz
                magazyn.add(produkt);
                System.out.println("Wrzuciłem do magazynu: " + produkt);
                Thread.sleep((int) (Math.random() * 10));
            }
        }catch (InterruptedException e){ System.out.println("Koniec wątu Producenta");
        }
    }
}