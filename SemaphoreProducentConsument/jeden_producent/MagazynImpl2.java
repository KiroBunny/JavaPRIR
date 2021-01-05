/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SemaphoreProducentConsument.jeden_producent;


import java.util.concurrent.Semaphore;

public class MagazynImpl2 implements Magazyn {

    private Semaphore producent;
    private Semaphore consument;
    private String [] produkt;
    private int size;
    private int addTemp = 0;
    private int getTemp = 0;

    public MagazynImpl2(int size) {
        producent = new Semaphore(size);
        consument = new Semaphore(0);
        produkt = new String[size];
        this.size = size;
    }

    @Override
    public void add(Object product) throws InterruptedException {
        producent.acquire();
        this.produkt[addTemp] = (String) product;
        addTemp ++;
        addTemp %= size;
        consument.release();
    }

    @Override
    public String get() throws InterruptedException {
        String tmp;
        consument.acquire();
        tmp = produkt[getTemp];
        getTemp++;
        getTemp %= size;
        producent.release();
        return tmp;
    }
    
}
