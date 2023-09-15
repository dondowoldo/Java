public class StringMethods {
    public static void main(String[] args) {
        String name = "John";
        String newName = "John";

        // Both variables print out the same hash as both variables
        // point at the same String saved in memory (String pool)
        System.out.println(name.hashCode());
        System.out.println(newName.hashCode());
    }
}
