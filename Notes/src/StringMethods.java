import java.util.Arrays;

public class StringMethods {
    String language = "Java";
    String course = "Green Fox";
    String classroom = "AVUS Botega";

    public static void main(String[] args) {
        // Both variables point at the same String saved in memory (String pool)
            String name = "John";
            String newName = "John";

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

        // METHODS OVERVIEW
        // When stating indexes, starting index is inclusive while ending index is exclusive
        animal = "Leopard";

        System.out.println(animal.length());        // Amount of characters in a string // Output: 7
        System.out.println(animal.substring(0, 3)); // Creates substring (startIndex(inclusive), endIndex(exclusive)) // end is optional   // Output: Leo

            // StringBuilder .replace method allows us to use indexes ;; with String we have to use literal substring
        System.out.println(sb.replace(0, 6, "Hamster"));        // SB | Replace part of a string with a new one             // Output: Hamster123
        System.out.println(animal.replace("Leo", "Ge"));       // String | Replace part of a string with a new one      // Output: Gepard

        System.out.println(animal.charAt(0));        // Gets a character at given index          // Output: L
        System.out.println(animal.equals("Leopard"));        // Check for equality (compares values, not address)                          // Output: True

        System.out.println(animal.compareTo("Gepard"));   // Compares Strings lexicographically | if < 0 => less ; if 0 => equal ; if > 0 => more   // Output: 5
        System.out.println(animal.toLowerCase());        // Transforms the string into all lowercase                                        // Output: leopard
        System.out.println(animal.contains("pard"));    // Checks if String contains given sequence of chars                                // Output: True
        System.out.println(animal.startsWith("Le"));    // Checks if String starts with given sequence of chars                             // Output: True
        System.out.println(animal.endsWith("phant"));        // Checks if String ends with given sequence of chars                          // Output: False
        System.out.println(animal.indexOf("par"));        // Checks for a char sequence and returns an index of FIRST occurrence | -1 if not in string       // Output: 3
        System.out.println(animal.lastIndexOf("par"));  // Checks for a char sequence and returns an index of LAST occurrence | -1 if not in string       // Output: 3

        System.out.println(Arrays.toString(animal.split("")));        // Splits a string into separate characters
                                                                            // argument for .split() method is a separator
                                                                            // Since we used split on string with no separator in it, we use ""         // Output: [L,e,o,p,a,r,d]


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