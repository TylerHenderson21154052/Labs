package Task01_2;

import java.util.Scanner;

public class ShapeCalculator2 
{
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Please select:\n(1) Rectangle\n(2) Circle\n(3) Square");
        try {
        switch(keyboard.nextInt()) {
            case 1:
                double length1, length2;
                
                    System.out.print("Input width: ");
                    length1 = keyboard.nextDouble();
                
                    System.out.print("Input length: ");
                    length2 = keyboard.nextDouble();
                
                    Rectangle recObj = new Rectangle(length1, length2) {};
                
                    recObj.calculateArea();
                    recObj.printInfo();
                
                    break;
                    
                case 2:
                    double radius;
                
                    System.out.print("Input radius: ");
                    radius = keyboard.nextDouble();
                
                    Circle cirObj = new Circle(radius) {};
                
                    cirObj.calculateArea();
                    cirObj.printInfo();
                
                    break;
                
                case 3:
                    double length;
                
                    System.out.print("Input radius: ");
                    length = keyboard.nextDouble();
                
                    Square squObj = new Square(length) {};
                
                    squObj.calculateArea();
                    squObj.printInfo();
                
                    break;
                
                default:
                    System.out.println("Wrong input");
                    return;
            }
        } catch(Exception e) {
            System.out.println("Invalid input. Not an integer");
            return;
        }
    }
}
