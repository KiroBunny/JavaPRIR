
package ksiazkatelefoniczna;

import java.util.Collection;


public interface IKsiazkaTelefoniczna {

    void addOsoba(IOsoba osoba);

    Collection<IOsoba> getByImie(String imie);

    Collection<IOsoba> getByNazwisko(String nazwisko);

    IOsoba remove(int id);
    
    int size();
    
}
