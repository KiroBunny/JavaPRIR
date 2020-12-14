package AlgWzajWykluczenia;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Licznik l = new Licznik();
        Monitor m = new MonitorImpl();

        Thread th1 = new Watek1(l, m);
        Thread th2 = new Watek2(l, m);

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.out.println(l.get());
    }
}
    interface Monitor {
        void proceduraWejsciowaWatek1();
        void proceduraWejsciowaWatek2();
        void proceduraWyjsciowaWatek1();
        void proceduraWyjsciowaWatek2();
    }

    class MonitorImpl implements Monitor {

        volatile boolean flag1 = true;
        volatile boolean flag2 = true;
        volatile int turn;

        public void proceduraWejsciowaWatek1() {
            flag1 = true;
            turn = 2;
            do {
            }while (flag2 && turn == 2);
        }

        @Override
        public void proceduraWejsciowaWatek2() {
            flag2 = true;
            turn = 1;
            do {
            }while (flag1 && turn == 1);
        }

        @Override
        public void proceduraWyjsciowaWatek1() {
            flag1 = false;
        }

        @Override
        public void proceduraWyjsciowaWatek2() {
            flag2 = false;
        }
    }

    class Watek1 extends Thread{
        Licznik l;
        Monitor m;
        public Watek1(Licznik l, Monitor m){
            this.l = l;
            this.m = m;
        }

        @Override
        public void run() {
            try{
                for (int i =0; i< 100; i++){
                    m.proceduraWejsciowaWatek1();
                    l.increment();
                    m.proceduraWyjsciowaWatek1();
                    System.out.println("W1, increment" + i);
                    sleep(10);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Watek2 extends Thread{
        Licznik l;
        Monitor m;
        public Watek2(Licznik l, Monitor m){
            this.l = l;
            this.m = m;
        }

        @Override
        public void run() {
            try{
                for (int i =0; i< 100; i++){
                    m.proceduraWejsciowaWatek2();
                    l.increment();
                    m.proceduraWyjsciowaWatek2();
                    System.out.println("W2, increment" + i);
                    sleep(10);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Licznik{
        public int licznik = 0;

        public void increment() {
            licznik ++;
        }

        public int get(){
            return licznik;
        }
    }

