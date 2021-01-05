/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SemaphoreProducentConsument.jeden_producent;

import java.util.concurrent.Semaphore;

public class Producent extends Thread {

    private Magazyn magazyn;

    public Producent(Magazyn m) {
        magazyn = m;

    }

    public void run() {
        int i = 0;
        try {
            while (true) {                
                String produkt = "" + i;                
                magazyn.add(produkt);
                i++;
                System.out.println("Wrzuciłem do magazynu: " + produkt);
                Thread.sleep((int) (Math.random() * 10));
            }
        } catch (InterruptedException e) {
            System.out.println("Koniec wątu Producenta");
        }
    }

}
