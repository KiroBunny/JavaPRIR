/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ksiazkatelefoniczna;

import java.util.*;

/**
 *
 * @author Marcin
 */
public class KsiazkaTelefoniczna implements IKsiazkaTelefoniczna {

    Map<Integer, IOsoba> id2Osoba = new HashMap<>(); //klucz musi posiadac dobrze zaimplementowane metody porownania
    Map<String, List<Integer>> imie2Id = new HashMap<>();
    Map<String, List<Integer>> nazwisko2Id = new HashMap<>();

    @Override
    public Collection<IOsoba> getByImie(String imie) {
        List<IOsoba> wynik = new ArrayList<>();
        List<Integer> list = imie2Id.get(imie);
        for( int id: list){
            IOsoba o = id2Osoba.get(id);
            wynik.add(o);
        }
        return wynik;
    }

    @Override
    public Collection<IOsoba> getByNazwisko(String nazwisko) {
        List<IOsoba> wynik = new ArrayList<>();
        List<Integer> list = nazwisko2Id.get(nazwisko);
        for( int id: list){
            IOsoba o = id2Osoba.get(id);
            wynik.add(o);
        }
        return wynik;
    }

    @Override
    public IOsoba remove(int id) {
        IOsoba os = id2Osoba.remove(id);
        List<Integer> list = imie2Id.get(os.getImie());
        List<Integer> listnaz = nazwisko2Id.get(os.getNazwisko());

        list.remove(new Integer(id));
        listnaz.remove(new Integer(id));

        return os;

    }

    @Override
    public void addOsoba(IOsoba osoba) {
        id2Osoba.put(osoba.getId(), osoba);
        if(!imie2Id.containsKey(osoba.getImie())){
            imie2Id.put(osoba.getImie(),new ArrayList<>());
        }
        List<Integer> idlist = imie2Id.get(osoba.getImie());
        if(!nazwisko2Id.containsKey(osoba.getNazwisko())){
            nazwisko2Id.put(osoba.getNazwisko(),new ArrayList<>());
        }
        List<Integer> idllist2 = nazwisko2Id.get(osoba.getNazwisko());

        idlist.add(osoba.getId());
        idllist2.add(osoba.getId());
    }

    @Override
    public int size() {
        return id2Osoba.size();
    }

}
