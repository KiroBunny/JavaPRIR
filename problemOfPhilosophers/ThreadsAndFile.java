package problemOfPhilosophers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ThreadsAndFile {
    public static void main(String[] args) throws InterruptedException {
        String[] files = {"plik1.txt", "plik2.txt", "plik3.txt", "plik4.txt", "plik5.txt"};
        Semaphore[] semaphores = new Semaphore[files.length];
        for (int i = 0; i <semaphores.length; i++){
            semaphores[i] = new Semaphore(1);
        }
        List<Thread> threads = new ArrayList<>();
        int n = 10;
        for (int i = 0; i < n; i++) {
            threads.add(new PhilosopherFile(files, semaphores));
        }
        threads.forEach(Thread::start);
        Thread.sleep(100);
        threads.forEach(Thread::interrupt);
    }
}
