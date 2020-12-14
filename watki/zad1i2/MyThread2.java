package watki.zad1i2;

public class MyThread2 implements Runnable{

    @Override
    public void run() {
        for( int i = 100; i <= 120; i++)
            System.out.println(i);
    }
}
