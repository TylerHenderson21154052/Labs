package Task01_2;

public abstract class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }
    @Override
    public void calculateArea() {
        area = Math.PI * Math.pow(radius, 2);
    }
}
