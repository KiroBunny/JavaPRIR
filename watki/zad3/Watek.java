package watki.zad3;

public class Watek extends Thread{
    private  int numer;
    static Licznik licznik = new Licznik();
    Watek(int id){
        numer = id;
    }

    @Override
    public void run() {
        System.out.println("Watek: " + numer);
        for (int i = 0; i < 100000; ++i){
            licznik.increment();
        }
    }
}
