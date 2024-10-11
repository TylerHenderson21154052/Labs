package Task01_2;

public abstract class Rectangle extends Shape {
    double length1, length2;

    public Rectangle(double length1, double length2) {
        super("Rectangle");
        this.length1 = length1;
        this.length2 = length2;
    }
    @Override
    public void calculateArea() {
        area = length1 * length2;
    }
}
