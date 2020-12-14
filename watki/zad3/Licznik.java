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
/* Jeśli nie korzystamy z synchronizacji wątków, to następuje problem zwiazany z dostępem do licznika w klasie Licznik. CHcemy aby po kolei każdy wątek inkrementował
 statyczną zmienną licznik, jednak bez synchronizacji wątki działają w tym samym czasie. Podczas gdy wątek1 pobierze kopie licznika do swojej pamięci inny wątek
 może zrobić to samo oraz też inkrementować, co finalnie daje, że dwa wątki działają na tym samym poprzednim stanie licznika. Nasza zmienna licznik, po zakończeniu programu,
 nie pokazuje poprawnego wyniku.
 */