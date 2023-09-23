public class Objects {
    public static void main(String[] args) {

        // Create new instance(peugeot) of an object (Car) and assign values.
        Car peugeot = new Car("Peugeot 206", 2000, false);

        System.out.println(peugeot);
    }
}

// Declare a new Car Class (Object) and its attributes.
class Car {
    String make;
    int year;
    boolean automatic;


    // Constructor method. Creates a new instance of an object Car.
    // "this" keyword assigns the value to each unique car (each instance) from the passed in argument.
    // Car = General object describing what every car should have
    // instance of Car object = particular car
    Car(String make, int year, boolean automatic) {

        // LEFT SIDE : "this.make" refers to an attribute of the Car object
        // RIGHT SIDE : "=make" refers to the argument passed in by calling the Car constructor
        //               (Car peugeot = new Car("Peugeot 206", 2000, false);

        this.make = make;
        this.year = year;
        this.automatic = automatic;
    }

    // Override original toString() method to be able to represent each instance of car object
    // however we like. Originally displays address of a Car instance in memory - Now displays attributes
    // of particular car on a separate line.
    public String toString() {
        return "Make: " + make + "\n" + "Made in: " +year + "\n" + "Automatic?: " + automatic;
    }
}
