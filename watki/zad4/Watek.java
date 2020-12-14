package watki.zad4;

public class Watek extends Thread {
    private int id;
    private int k;
    Watek(int id, int k){
        this.id = id;
        this.k = k;
    }
    @Override
    public void run() {
        int idNajmniejsza;
        Kolekcja map = new Kolekcja();
        idNajmniejsza = map.szukajNajmniejszej(id, k);
        map.zapiszId(idNajmniejsza);
    }
}
