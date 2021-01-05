package problemOfPhilosophers;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int NUMBER_OF_STICKS = 5;
        Semaphore[] sticks = new Semaphore[NUMBER_OF_STICKS];
        Semaphore table = new Semaphore(NUMBER_OF_STICKS-1);



        for (int i=0; i<NUMBER_OF_STICKS; i++){
            sticks[i] = new Semaphore(1);
        }


//        for (int i=0; i<NUMBER_OF_STICKS; i++){
//            new Philosopher(sticks, i, table).start();
//        }


        for (int i=0; i<NUMBER_OF_STICKS; i++){
            new PhilosopherWithoutExtraLock(sticks, i).start();
        }

    }
}
