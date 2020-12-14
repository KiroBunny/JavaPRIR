package watki.zad4;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class Kolekcja {
    static Map<Integer, Double> map = new TreeMap<>();
    static int idNajmniejszej = 999999;

    public void setMap(int key, double value) {
        map.put(key, value);
    }

    public static int getIdNajmniejszej() {
        return idNajmniejszej;
    }

    public int szukajNajmniejszej(int idWatku, int k) {
        int lKluczy = map.size()/k, idNajmniejsze=0;
        double wartosc, mniejsza = map.get(lKluczy*idWatku);
        for (int i = idWatku*lKluczy; i < (idWatku+1)*lKluczy; i++){
            wartosc = map.get(i);
            if(wartosc < mniejsza) {
                mniejsza = wartosc;
                idNajmniejsze = i;
            }
        }
        return idNajmniejsze;
    }

    public synchronized void zapiszId(int id){
        if(id < idNajmniejszej)idNajmniejszej = id;
    }
}
