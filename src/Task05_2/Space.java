package Task05_2;

/**
 *
 * @author Tyler Henderson
 */

public class Space implements Runnable {
    
    Switch call;
    int totalRows;

    public Space(int totalRows, Switch call) {
        this.totalRows = totalRows;
        this.call = call;
        new Thread(this, "Space").start();
    }
    
    @Override
    public void run() {
        
        for (int i = 1; i <= totalRows; i++) {

            //Print spaces
            for (int j = 0; j < (totalRows - i); j++) {
                System.out.print(" ");
            }
            call.call(i);
        }
    }
}
