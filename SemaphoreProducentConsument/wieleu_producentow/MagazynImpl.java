/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SemaphoreProducentConsument.wieleu_producentow;

import java.util.concurrent.Semaphore;


public class MagazynImpl implements Magazyn {
    private Semaphore producent;
    private Semaphore consument;
    private String [] produkt;
    private Semaphore addSem = new Semaphore(1);
    private Semaphore getSem = new Semaphore(1);
    private int size;
    private int addTemp = 0;
    private int getTemp = 0;

    MagazynImpl(int size) {
        producent = new Semaphore(size, true);
        consument = new Semaphore(0);
        produkt = new String[size];
        this.size = size;
    }
    @Override
    public void add(Object product) throws InterruptedException {
        producent.acquire();

        addSem.acquire();
        this.produkt[addTemp] = (String) product;
        addTemp ++;
        addTemp %= size;
        addSem.release();

        consument.release();
    }

    @Override
    public String get() throws InterruptedException {
        String tmp;
        consument.acquire();

        getSem.acquire();
        tmp = produkt[getTemp];
        getTemp++;
        getTemp %= size;
        getSem.release();

        producent.release();
        return tmp;
    }

}
