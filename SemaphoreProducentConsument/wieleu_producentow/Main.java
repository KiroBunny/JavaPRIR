
package SemaphoreProducentConsument.wieleu_producentow;

import java.util.ArrayList;
import java.util.List;

public class Main {

  
    public static void main(String[] args) throws InterruptedException {
        Magazyn m = new MagazynImpl(3);
        List<Thread> th = new ArrayList<>();
        for (int i=0; i<10;i++) {
            Thread producent = new Producent(m);
            th.add(producent);
        }
        Thread konsument = new Consument(m);
        th.add(konsument);
        th.forEach(Thread::start);
        Thread.sleep(1000);
        th.forEach(Thread::interrupt);
    }
    
}
