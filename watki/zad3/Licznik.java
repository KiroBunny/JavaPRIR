package watki.zad3;

public class Licznik {
    int licznik;
    Licznik( ) {licznik = 0;}
/*    synchronized */ void  increment(){
        licznik++;
    }
    int get(){
        return licznik;
    }
}
