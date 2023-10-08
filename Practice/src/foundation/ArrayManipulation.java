package foundation;

import java.util.Arrays;

public class ArrayManipulation {
    // #1    Write a function that takes an arbitrarily large array of integers as a
    //       parameter and doubles each member at an even index in the array.

    // #2   Modify the function to accept a second parameter in the value "odd" or "even",
    //      where the number on the odd or even index will be doubled according to the value
    //      of the second parameter.

    // #3   Modify the function so it will sort the array from the largest number
    //      to the smallest number without use of any library (e.g. Collections etc.).


    public static void main(String[] args) {
        // Step 1
        System.out.println(Arrays.toString(doubleEachEvenStepOne(new int[]{0, 1, 3, 8, 4, 6, 9})));

        // Step 2
        System.out.println(Arrays.toString(doubleEachEvenStepTwo(new int[]{0, 1, 3, 8, 4, 6, 9}, "odd")));

        // Step 3
        System.out.println(Arrays.toString(sortFromLargestBubble(new int[]{0, 1, 3, 8, 4, 6, 9})));

        System.out.println(Arrays.toString(sortFromLargestSelection(new int[]{0, 1, 3, 8, 4, 6, 9})));
    }

    public static int[] doubleEachEvenStepOne(int[] input) {
        for (int i = 0; i < input.length; i += 2) {
            input[i] *= 2;
        }
        return input;
    }

    public static int[] doubleEachEvenStepTwo(int[] input, String value) {
        int start;
        switch (value) {
            case "even":
                start = 0;
                break;
            case "odd":
                start = 1;
                break;
            default : throw new IllegalArgumentException();
        }

        for (int i = start; i < input.length; i += 2) {
            input[i] *= 2;
        }
        return input;
    }

    //Bubble sort
    public static int[] sortFromLargestBubble(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            while(input[i] > input[i+1]) {
                int tmp = input[i+1];
                input[i+1] = input[i];
                input[i] = tmp;
            }
        }
        return input;
    }

    // Selection sort
    public static int[] sortFromLargestSelection(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = input[minIndex];
            input[minIndex] = input[i];
            input[i] = tmp;
        }
        return input;
    }
}
