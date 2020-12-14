package watki.zad3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Watek.licznik.get());
        int ileWatkow = 10;
        Watek watki[] = new Watek[ileWatkow];
        for (int i = 0; i < ileWatkow; i++){
            watki[i] = new Watek(i + 1);
            watki[i].start();
        }
        for (int i = 0; i< ileWatkow; i++){
            watki[i].join();
        }
        System.out.println(Watek.licznik.get());
    }
}
// Komentarz do synchronizacji w klasie Licznik