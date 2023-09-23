import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;
import java.util.List;

public class ArrayLists {
    public static void main(String[] args) {

        // ArrayList can use only objects ( NOT primitive types )
        // We specify the type (if we want to) on the declaration side (left) , no need in initialisation (right)
        // Every constructor ends with "()" even if no arguments given

        ArrayList<Integer> nums = new ArrayList<>();

        // METHODS

        // nums.add(number) - Adds a number at the end of the ArrayList
        // nums.add(index, number) - Adds a number at the specified index and shifts the rest
        // nums.remove(index) - Removes a value from ArrayList at index and reformats indexes in ArrayList

            nums.add(1);
            nums.add(2);
            nums.add(3);
            nums.add(3, 4);

        // to print value at i, we need to use nums.get(i) method, NOT nums[i] unlike Arrays
        // To find the amount of values stored in ArrayList we need nums.size() method, NOT nums.lenght() unlike Arrays

            for (int i=0; i < nums.size(); i++) {
                System.out.printf("Index: %d  ;  Number: %d\n", i, nums.get(i));
            }

        System.out.println("----------");

        // We can still use the enhanced for loop just like with Arrays (if we don't need index count)
            for (int number : nums) {
                System.out.printf("Number: %d\n", number);
            }

        // SWAP first and last element of ArrayList using nums.set(index, value) method
            int temp = nums.get(0);
            nums.set(0, nums.get(2));
            nums.set(2, temp);

            System.out.println("---ELEMENT SWAP----");
            for (int number : nums) {
                System.out.printf("Number: %d\n", number);
            }

        //  ITERATOR
            Iterator individual = nums.iterator();

            // Iterates through our nums ArrayList and as long as there are more numbers, it will print them one by one
            while(individual.hasNext()) {
                System.out.println(individual.next());
            }

        // Copy an entire collection into a new one with "new.addAll(original)" method
            ArrayList<Integer> copyNums = new ArrayList<>();
            copyNums.addAll(nums);

            System.out.println(nums);           // Output: [3, 2, 1, 4]
            System.out.println(copyNums);       // Same output

        // Check if a particular value is in the collection using .contains method
            int newNumber = 10;
            nums.add(newNumber);
            if (nums.contains(newNumber)) {
                System.out.println("Number " + newNumber + " is in the ArrayList.");
            }

        //  Check if an entire collection is included in another collection
            if (nums.containsAll(copyNums)) {                           // Evaluates to true as nums has all elements of copyNums + one extra(newNumber)
                System.out.println("Everything is included");           // If other way around => would evaluate to false.
            }

        // Delete every element inside of ArrayList and check using .isEmpty() method
            nums.clear();
            if (nums.isEmpty()) {
                System.out.println("ArrayList is empty.");
            }

        // Copy an ArrayList inside of a new Array.
        //  1. Create new generic object with fixed length, use .toArray() method to convert and put inside moreNums variable
            Object[] moreNums = new Object[4];
            moreNums = copyNums.toArray();
            System.out.println(Arrays.toString(moreNums));      // Output: [3, 2, 1, 4]    (as array)

        // convert values into a list [1, 2, 3, 4] and add it to our nums List.
        // Both examples do the same thing.
            nums.addAll(Arrays.asList(1, 2, 3, 4));
            nums.addAll(Arrays.asList(new Integer[] {1, 2, 3, 4}));


            List<Integer> ListExample = new ArrayList<>(Arrays.asList(1, 2, 3, 4));


                            /// DIFFERENCES

        //      Arrays                         // ArrayLists

        //      []                              <>
        //      Objects/Primitive types         Objects Only
        //      Fixed size                      Flexible size
        //      array[i]                        arrayList.get(i)
        //      array.length()                  arrayList.size()

    }
}
