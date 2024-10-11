package Task05_2;

/**
 *
 * @author Tyler Henderson
 */

public class Aster implements Runnable{
    
    Switch call;
    int totalRows;

    public Aster(int totalRows, Switch call) {
        this.totalRows = totalRows;
        this.call = call;
        new Thread(this, "Aster").start();
    }
    
    @Override
    public void run() {
        
        for (int i = 1; i <= totalRows; i++) {

            //Print stars
            for (int j = 0; j < (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
            call.call(i);
        }
    }
}
