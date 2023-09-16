import java.util.ArrayList;

public class ArrayLists {
    public static void main(String[] args) {

        // ArrayList can use only objects ( NOT primitive types )
        // We specify the type on the declaration side , no need in initialisation
        // Every constructor ends with "()" even if no arguments given

        ArrayList<Integer> nums = new ArrayList<>();

        // METHODS

        // nums.add(number) - Adds a number at the end of the ArrayList
        // nums.remove(index) - Removes a value from ArrayList at index and reformats indexes in ArrayList

            nums.add(1);
            nums.add(2);
            nums.add(3);

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

                            /// DIFFERENCES

        //      Arrays                         // ArrayLists

        //      []                              <>
        //      Objects/Primitive types         Objects Only
        //      Fixed size                      Flexible size
        //      array[i]                        arrayList.get(i)
        //      array.length()                  arrayList.size()

    }
}
