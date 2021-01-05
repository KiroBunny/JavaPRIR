package problemOfPhilosophers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Semaphore;

public class PhilosopherFile extends Thread {

    private String [] files;
    private Semaphore[] semaphores;

    public PhilosopherFile(String[] files, Semaphore[] semaphores) {
        this.files = files;
        this.semaphores = semaphores;
    }

    @Override
    public void run() {

        int id1 = (int) (Math.random() * (files.length));
        int id2;
        do{
        id2 = (int) (Math.random() * (files.length));
        }while (id1 == id2);
        int id1sem = Math.min(id1, id2);
        int id2sem = Math.max(id1, id2);

        semaphores[id1sem].acquireUninterruptibly();
        semaphores[id2sem].acquireUninterruptibly();
        String file1 = files[id1];
        String file2 = files[id2];

        try (PrintStream ps = new PrintStream(new FileOutputStream(file2, true))){
            List<String> list = Files.readAllLines(Paths.get(file1));
            ps.println("Thread: " + this.getId() + " :: " + list.get(0));
            System.out.println( "Watek " + this.getId() + "  O:  " + file1 + "    Z: " + file2);


        } catch (IOException e) {
            e.printStackTrace();
        }/*finally {
            if(ps != null) ps.close();
        }*/

        semaphores[id1sem].release();
        semaphores[id2sem].release();

    }
}
