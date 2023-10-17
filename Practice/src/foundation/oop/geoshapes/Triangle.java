package foundation.oop.geoshapes;

public class Triangle extends Shape {
    private int sideA;
    private int sideB;
    private int sideC;

    public Triangle(int sideA, int sideB, int sideC) {
        if (sideA + sideB > sideC && sideB + sideC > sideA && sideA + sideC > sideB) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        } else {
            throw new IllegalArgumentException("Not a triangle");
        }
    }


    @Override
    public int getArea() {
        double p = getHalfPerimeter();
        return (int)Math.round(Math.sqrt(p * (p - this.sideA) * (p - this.sideB) * (p - this.sideC)));
    }

    private double getHalfPerimeter() {
        return (this.sideA + this.sideB + this.sideC) / 2.0;
    }
}
