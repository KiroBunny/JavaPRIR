package threads.breaking;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.Thread.sleep;


public class BreakingTask4ToDo implements Runnable {
    int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new BreakingTask4ToDo());
        t.start();
        sleep(5000);
        System.out.println("Przerwanie wątku");
        t.interrupt();

    }


    @Override
    public void run() {

        while (true) {
            System.out.println("run: " + counter);
            Map<String, Integer> map = new HashMap<>();
            generatemMap(map);
            maxRoznica(map);
            counter++;
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Nastapilo przerwanie watku");
                break;
            }
        }
    }

    public void generatemMap(Map<String, Integer> map) {
        Random r = new Random();
        System.out.println("generateMap: " + counter);
        try {
            for (int i = 0; i < 1000; i++) {
                String key = "" + r.nextInt(10);
                Integer val = map.get(key);
                val = val == null ? 1 : val + 1;
                map.put(key, val);
                sleep(1);
            }
        } catch (InterruptedException e) {
            System.out.println("generateMap: wyjątek");
            Thread.currentThread().interrupt();
        }
    }

    public void maxRoznica(Map<String, Integer> map) {
        int maxDX = 0;
        System.out.println("maxRoznica: " + counter);

        try {
            for (Map.Entry<String, Integer> e1 : map.entrySet()) {
                for (Map.Entry<String, Integer> e2 : map.entrySet()) {
                    int dx = Math.abs(e1.getValue() - e2.getValue());
                    if (dx > maxDX) {
                        maxDX = dx;
                    }
                }
                sleep(1);
            }
        } catch (InterruptedException e) {
            System.out.println("maxRoznica: wyjątek");
            Thread.currentThread().interrupt();
        }
        System.out.println("Maksymalna różnica to: " + maxDX);
    }
}

