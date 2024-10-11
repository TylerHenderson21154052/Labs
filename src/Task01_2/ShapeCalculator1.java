package Task01_2;

public class ShapeCalculator1 {
    
    public static void main(String[] args) {
        Circle cirObj = new Circle(2.5) {};
        Rectangle recObj = new Rectangle(12, 16.5) {};
        
        cirObj.calculateArea();
        cirObj.printInfo();
        
        recObj.calculateArea();
        recObj.printInfo();
        
        Square squObj = new Square(3.3) {};
        
        squObj.calculateArea();
        squObj.printInfo();
    }
}
