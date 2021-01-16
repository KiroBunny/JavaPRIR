package PrzykladZastosowania;

public class ThSynch2 extends Thread {
    Synchronisations synch;

    public ThSynch2(Synchronisations synch) {
        this.synch = synch;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synch.startB();
                for (int i = 100; i <= 120; i += 2) {
                    System.out.print(i + ",b ");
                }
                System.out.println();
                synch.stopB();
            }
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
    }
}
