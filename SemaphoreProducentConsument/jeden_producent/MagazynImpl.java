/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SemaphoreProducentConsument.jeden_producent;


import java.util.concurrent.Semaphore;

public class MagazynImpl implements Magazyn {

    private Semaphore producent;
    private Semaphore consument;
    private String produkt;

    public MagazynImpl() {
        producent = new Semaphore(1);
        consument = new Semaphore(0);
    }

    @Override
    public void add(Object product) throws InterruptedException {

        producent.acquire();
        this.produkt = (String) product;
        consument.release();

    }

    @Override
    public String get() throws InterruptedException {
        consument.acquire();
        producent.release();
        return produkt;
    }
    
}
