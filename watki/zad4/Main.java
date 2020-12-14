package watki.zad4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int k = 15; // liczba watków
        Watek watki[] = new Watek[k];
        String holder[];
        Kolekcja map = new Kolekcja();

        File file = new File("dane.txt");
        try (Scanner sc = new Scanner(file);) {
            String text;
            int i = 0;
            while (sc.hasNext()) {
                text = sc.nextLine();
                holder = text.split(";");
                map.setMap(Integer.parseInt(holder[0]), Double.parseDouble(holder[1]));
                }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        long start=System.currentTimeMillis();

        for (int i = 0; i < k; i++){
            watki[i] = new Watek(i , k);
            watki[i].start();                   //usun public z kolekcji
        }
        for (int i = 0; i < k; i++){
            watki[i].join();
        }

        long stop=System.currentTimeMillis();

        System.out.println("Id dla najmniejszej pensji = " + map.getIdNajmniejszej());
        System.out.println("Czas wykonania:"+(stop-start));
    }
}
