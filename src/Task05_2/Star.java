package Task05_2;

public class Star extends Thread {
    
    public static void main(String[] args) {
        int max = 9;
        
        System.out.println("Figure:");
        
        Switch call = new Switch(max);
        
        new Space(max, call);
        new Aster(max, call);
    }
}
