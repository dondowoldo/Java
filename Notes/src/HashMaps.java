import java.util.HashMap;

public class HashMaps {
    public static void main(String[] args) {

        // Hashmaps store key/value pairs
        // Declaration includes stating data types of both keys and values eg. (String, String) , (String, Integer) , ...
        // Keys on the left, Values on the right
        // We !! CANNOT !! index into HashMaps as the key/value pairs may not be in order.

        HashMap<String, String> prague = new HashMap<>();

        prague.put("Praha1","Stare Mesto");     // "Praha1" = key ; "Stare Mesto" = value
        prague.put("Praha2", "Nove Mesto");
        prague.put("Praha3", "Zizkov");
        prague.put("Praha4", "Nusle");

        // Prints the value associated with the key "Praha3"   // Output: Zizkov
            System.out.println(prague.get("Praha3"));

        // Removes the entire key/value pair from the Hashmap associated with given key
            prague.remove("Praha4");
            System.out.println(prague);


        // Prints out the result of a boolean expression (Fairly used in if statements)
            System.out.println(prague.containsValue("Stare Mesto"));        // Output: True
            System.out.println(prague.containsKey("Praha5"));               // Output: False

        // Prints the amount of key/value pairs in Hashmap
            System.out.println(prague.size());

        // Replaces the value stored at "Praha1" key
            System.out.println(prague.replace("Praha1", "Mala Strana")); // Still prints out the old value that is being replaced   // Output: Stare Mesto
            System.out.println(prague);     // Prints out HashMap again with the new value (Mala Strana)

        // Prints out all the keys
            System.out.println(prague.keySet());        // Output: [Praha3, Praha2, Praha1]
    }
}
