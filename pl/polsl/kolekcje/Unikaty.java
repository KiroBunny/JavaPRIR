package pl.polsl.kolekcje;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

public class Unikaty {
    public static void main(String[] args) {
        File file = new File("baza.txt");

        try (Scanner sc = new Scanner(file);
             PrintWriter writer = new PrintWriter("unikaty.txt");){
            Collection<String> col = new HashSet<>();
            String text;
            while (sc.hasNext()) {
                sc.next();
                text = sc.next();
                sc.next();
                col.add(text);
            }
            for (String s: col) {
            writer.println(s);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }
}
