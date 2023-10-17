package foundation.oop.geoshapes;

public class Main {
    public static void main(String[] args) {

        // Create specific geometric shape classes, such as "Circle," "Rectangle," and "Triangle."
        // Customize these shape classes by providing attributes and
        // methods specific to each shape. For example, square will have
        // one attribute side length, circle will have one attribute diameter,
        // rectangle will have two attriburtes, sideA and sideB
        // Every shape will have a method getArea() which returns total area of the shape.
        //
        // Create a class named "ShapeStorage" that stores instances of different shapes.
        // You should be able to add, shapes
        // You should be able to getTotalArea of all shapes in the Shape storage class

        ShapeStorage storage = new ShapeStorage();
        Shape triangle = new Triangle(4, 4, 6);
        Shape circle = new Circle(16);
        Shape rectangle = new Rectangle(4, 8);

        storage.addShape(triangle);
        storage.addShape(circle);
        storage.addShape(rectangle);

        System.out.println(storage.getTotalArea());
    }
}
