package pl.polsl.kolekcje;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Czestosc {
    public static void main(String[] args) {
        File file = new File("tekst.txt");
        Map<String, Integer> map = new TreeMap<>();
        try (Scanner sc = new Scanner(file);){
            String text;
            int i =0;
            while (sc.hasNext()) {
                text = sc.next();
                text = text.toLowerCase();
                if(!map.containsKey(text))map.put(text, 1);
                else{
                    i = map.get(text);
                    map.put(text, i+1);
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();

        }
        int i = 0;
         Set<String> set = map.keySet();
        for (String k: set) {
            if(i ==10) break;
            System.out.println(k + " " + map.get(k));
            i++;
        }
    }
}

