package PrzykladZastosowania;

public class ThSynch3 extends Thread {
    Synchronisations synch;

    public ThSynch3(Synchronisations synch) {
        this.synch = synch;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synch.startC();
                for (int i = 1; i < 50; i+=2) {
                    System.out.print(i + ",c ");
                }
                System.out.println("");
                synch.stopC();
            }
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
    }
}
