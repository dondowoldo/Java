package foundation.oop.geoshapes;

public class Circle extends Shape {
    private int diameter;
    public Circle(int diameter) {
        this.diameter = diameter;
    }






    @Override
    public int getArea() {
        return (int)Math.round(Math.PI * Math.pow(this.diameter / 2.0, 2));
    }
}
