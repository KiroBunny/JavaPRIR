
package ksiazkatelefoniczna;

import java.util.Collection;
public class Main {

    public static void main(String[] args) {
        IKsiazkaTelefoniczna ksiazkaTelefoniczna = new KsiazkaTelefoniczna();
        IOsoba o1, o2, o3;
        //Dodajemy osoby
        o1 = new Osoba("Jan", "Kowalski", "31 123-345-543");
        ksiazkaTelefoniczna.addOsoba(o1);
        o2 = new Osoba("Jan", "Nowak", "21 10-10-10-01");
        ksiazkaTelefoniczna.addOsoba(o2);
        o3 = new Osoba("Marek", "Kowalski", "32 44-55-66-77");
        ksiazkaTelefoniczna.addOsoba(o3);
        //Sprawdzamy wyszukiwanie po imieniu
        Collection<IOsoba> kol = ksiazkaTelefoniczna.getByImie("Jan");
        if(kol.size() != 2) {
            System.out.println("Blad rozmiaru by imie");
            System.exit(1);
        }

        for (IOsoba o : kol) {
            if (!"Jan".equals(o.getImie())) {
                System.out.println("Błąd");
                System.exit(1);
            }
        }

        //Sprawdzamy rozmiar
        if (ksiazkaTelefoniczna.size()!=3){
            System.out.println("Błąd rozmiaru listy");
            System.exit(1);
        }

        //Usuwamy element
        ksiazkaTelefoniczna.remove(o2.getId());
        //Sprawdzamy rozmiar
        if (ksiazkaTelefoniczna.size()!=2){
            System.out.println("Błąd rozmiary Książki Adresowej");
            System.exit(1);
        }

        //Wyszukujemy po nazwisku - powinno być dwóch kowalskich
        String nazwisko = "Kowalski";
        kol = ksiazkaTelefoniczna.getByNazwisko(nazwisko);
        int i = 0;
        if(kol.size() != 2){
            System.out.println("blad rozmiaru po nazwisku");
            System.exit(1);
        }
        for(IOsoba o : kol){
            if (!"Kowalski".equals(o.getNazwisko())){
                System.out.println("Błąd osoba powinna mieć innego nazwiska niż Kowalski ");
                System.exit(1);
            }
            i++;
        }
    }
}
