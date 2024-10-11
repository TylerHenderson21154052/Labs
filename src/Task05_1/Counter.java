package Task05_1;

public class Counter extends Thread {
    
    int num;

    public static void main(String[] args) {
        Counter countOdd = new Counter(1);
        Counter countEven = new Counter(2);
        
        Thread oddThread = new Thread(countOdd);
        Thread evenThread = new Thread(countEven);
        
        oddThread.start();
        evenThread.start();
    }

    public Counter(int i) {
        this.num = i;
    }
    
    @Override
    public void run() {
        for (int j = this.num; j <= 10; j += 2) {
            System.out.print(j + " ");
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
