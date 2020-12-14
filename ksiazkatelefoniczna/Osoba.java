package ksiazkatelefoniczna;

import java.util.Objects;

public class Osoba implements IOsoba {

    String imie;
    String nazwisko;
    String nrTelefonu;
    int id;
    static int count = 0;

    public Osoba(String imie, String nazwisko, String nrTelefonu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrTelefonu = nrTelefonu;
        this.id = count;
        count++;
    }


    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getImie() {
        return imie;
    }

    @Override
    public String getNazwisko() {
        return nazwisko;
    }

    @Override
    public String getNrTelefonu() {
        return nrTelefonu;
    }

    @Override
    public void setImie(String imie) {
        this.imie = imie;
    }

    @Override
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Override
    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Osoba osoba = (Osoba) o;
        return id == osoba.id &&
                Objects.equals(imie, osoba.imie) &&
                Objects.equals(nazwisko, osoba.nazwisko);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, nazwisko, id);
    }
}
