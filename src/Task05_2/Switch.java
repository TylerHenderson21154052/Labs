package Task05_2;

class Switch {
    int rows;
    
    public Switch(int rows) {
        this.rows = rows;
    }
    synchronized void call(int row) {
        notify();
        if (row == rows) {
            return;
        }
        try {
            wait();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}