package ThreadTask;

public class NewThread extends Thread {

    private int id;
    private static final Boolean[] tabBool = new Boolean[10]; // true - watek pracuje, false - zakonczyl dzialanie

    static {
        for (int i=0; i<5; i++){
        tabBool[i] = true;
        tabBool[i+5] = false;
        }
    }

    NewThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
        while(true){

            synchronized (tabBool) {
            while(id < 5 && !tabBool[id] ) {tabBool.wait();}
            while (id >=5 && !tabBool[id] ){tabBool.wait();}


            }
                System.out.println(id);

            synchronized (tabBool) {

                tabBool[id] = false;
                int idpom = id > 4 ? id - 5 : id+5;
                tabBool[idpom] = true;
            }

            /*synchronized (tabBool){
                while (tabBool[id]){
                    tabBool.wait();
                }
            }
            System.out.println(id);
            synchronized (tabBool){
                tabBool[id] = true;
                if(id<5){
                    if(tabBool[0] && tabBool[1] && tabBool[2] && tabBool[3] && tabBool[4])
                        for (int i = 5; i<10; i++)tabBool[i] = false;
                }else {
                    if(tabBool[5] && tabBool[6] && tabBool[7] && tabBool[8] && tabBool[9])
                        for (int i = 0; i<5; i++)tabBool[i] = false;
                }
            }
*/


        }

        } catch (InterruptedException ignored) {

        }
    }

    boolean tab04(){
        return tabBool[0] || tabBool[1] || tabBool[2] || tabBool[3] || tabBool[4];
    }
    boolean tab59(){
        return tabBool[5] || tabBool[6] || tabBool[7] || tabBool[8] || tabBool[9];
    }


}
