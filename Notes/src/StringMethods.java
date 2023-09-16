
public class StringMethods {
    String language = "Java";
    String course = "Green Fox";
    String classroom = "AVUS Botega";

    public static void main(String[] args) {
        String name = "John";
        String newName = "John";

        // Both variables print out the same hashCode as both variables
        // point at the same String saved in memory (String pool)
            System.out.println("Hash code 1: " + name.hashCode());
            System.out.println("Hash code 2: " + newName.hashCode());

        // STRINGBUILDER
            String animal = "Cat";
            StringBuilder sb = new StringBuilder(animal);

        // Appends at the end of a String       // Output: Cat123
            sb.append(123);
            System.out.println(sb);

        // Deletes chars between (start inclusive, end exclusive => hence 3 in Cat123)      // Output: 123
            sb.delete(0, 3);
            System.out.println(sb);

        // Reverses a String        // Output: 321
            sb.reverse();
            System.out.println(sb);

        // Inserts text starting at given offset        // Output: Dog321
            sb.insert(0, "Dog");
            System.out.println(sb);

        // Deletes a char at given index        // Output: Dog21
            sb.deleteCharAt(3);
            System.out.println(sb);

        // Replace a piece of a String between start (inclusive) / end (exclusive) indexes.     // Output: Parrot321
            sb.replace(0, 3, "Parrot3");
            System.out.println(sb);

        System.out.println("-----------------");


        // toString() method is a visual representation of an object
        // shows String address by default but can be overridden
        // Once overridden, We can call both explicitly and implicitly providing the same result (example below)

            StringMethods strMethods = new StringMethods(); // create new instance of StringMethods() object
            System.out.println("Explicit call: ");
            System.out.println(strMethods.toString());

            System.out.println();

            System.out.println("Implicit call: ");
            System.out.println(strMethods);
    }

        // toString() method override.

        // Before implementation, output of both strMethods and strMethods.toString() was :
        // StringMethods@7291c18f

        // After implementation, output of both strMethods and strMethods.toString() is :
        //  Java
        //  Green Fox
        //  AVUS Botega

            public String toString() {
                return language + "\n" + course + "\n" + classroom;
            }
}