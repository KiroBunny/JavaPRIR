package threads.breaking;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.Thread.sleep;



public class BreakingTask3ToDo implements Runnable {
    int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new BreakingTask3ToDo());
        t.start();
        sleep(500);
        System.out.println("Wywołuję przerwanie wątku");
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
            if(Thread.currentThread().isInterrupted()){

                break;

            }
        }
    }

    public void generatemMap(Map<String, Integer> map) {
        Random r = new Random();
        System.out.println("generateMap: "+counter);
        for (int i = 0; i < 1000; i++) {
            if(Thread.currentThread().isInterrupted()){break;}
            String key = "" + r.nextInt(10);
            Integer val = map.get(key);
            val = val == null ? 1 : val + 1;
            map.put(key, val);
        }
    }


    public void maxRoznica(Map<String, Integer> map) {
        int maxDX = 0;
        System.out.println("maxRoznica: " + counter);
        for (Map.Entry<String, Integer> e1 : map.entrySet()) {
            for (Map.Entry<String, Integer> e2 : map.entrySet()) {
                if(Thread.currentThread().isInterrupted()){break;}
                int dx = Math.abs(e1.getValue() - e2.getValue());
                if (dx > maxDX) {
                    maxDX = dx;
                }
            }
            if(Thread.currentThread().isInterrupted()){
                break;
            }
        }
        System.out.println("Maksymalna różnica to: " + maxDX);
    }
}

