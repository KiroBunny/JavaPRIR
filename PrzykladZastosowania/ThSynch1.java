package PrzykladZastosowania;

public class ThSynch1 extends Thread {
    private Synchronisations synch;

    ThSynch1(Synchronisations synch) {
        this.synch = synch;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synch.startA();
                for (int i = 1; i <= 20; i++) {
                    System.out.print(i + ",a ");
                }
                System.out.println();
                synch.stopA();
            }
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
    }
}
