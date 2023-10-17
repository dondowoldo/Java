package foundation.oop.geoshapes;

public class Rectangle extends Shape {
    private int sideA;
    private int sideB;

    public Rectangle(int sideA, int sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }


    @Override
    public int getArea() {
        return this.sideA * this.sideB;
    }
}
