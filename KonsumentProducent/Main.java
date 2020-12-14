package KonsumentProducent;

import java.lang.management.RuntimeMXBean;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Magazyn m = new Magazyn();
        Thread t1 = new Thread(new Producent(m));
        Thread t2 = new Thread(new Konsument(m));
        t1.start();
        t2.start();
        Thread.sleep(10000);
        t1.interrupt();
        t2.interrupt();

        System.out.println("koniec");
    }
}

class Magazyn {
    String towar;
    boolean jestTowar = false;
    int k =3;
    int lpm = 0;
    int lg=0;
    int ls=0;
    String tab [] = new String[k];

    synchronized void set(String towar) throws InterruptedException {
        while (lpm == k) {
            this.wait();
        }
        //this.towar = towar;
        tab[ls%3] = towar;
        ls++;
        lpm++;
        System.out.println("SET " + towar);
        //jestTowar = true;
        notifyAll();
    }

    synchronized String get() throws InterruptedException {
        while (lpm == 0) {
            this.wait();
        }
        //jestTowar = false;
        towar = tab[lg%3];
        lg++;
        lpm--;
        System.out.println("GET  " + towar);
        notifyAll();
        return towar;
    }
}

class Producent implements Runnable {
    Magazyn m;
    int towarIs;

    public Producent(Magazyn m) {
        this.m = m;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep((long) (100* Math.random()));
                m.set("Towar id:" + towarIs);
                towarIs++;
            }
        } catch (InterruptedException e) {

        }

    }
}

class Konsument implements Runnable {
    Magazyn m;

    public Konsument(Magazyn m) {
        this.m = m;
    }

    public void run() {

        try {
            while (true) {
                Thread.sleep((long) (500 * Math.random()));
                String s = m.get();
                System.out.println("Pobralem towar: " + s);
            }
        } catch (InterruptedException e) {

        }

    }
}