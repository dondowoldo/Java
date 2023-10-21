import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        // 1. Reduction
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
//        int sum = numbers.stream().mapToInt(i -> i).sum(); // using sum
//        int sum = numbers.stream().reduce(0, Integer::sum); // same thing as below
        int sum = numbers.stream().reduce(0, (i, j) -> i + j); // using reduce
        System.out.println(sum);

        // 2. Grouping
        List<String> fruits = new ArrayList<>(List.of("apple", "banana", "avocado", "cherry"));
        Map<Integer, List<String>> fruitMap = fruits.stream()
                        .collect(Collectors.groupingBy(String::length));
        System.out.println(fruitMap);

        // 3. Joining
        String allFruits = fruits.stream()
                .collect(Collectors.joining(","));
        System.out.println(allFruits);

        // 4. Peek
        numbers.stream()
                .peek(i -> System.out.print(i + " | "))
                .map(i -> i * 2)
                .forEach(System.out::println);

        // 5. Limit and Skip
        List<Integer> firstThreeOnly = numbers.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(firstThreeOnly);

        // 6. Distinct
        numbers = new ArrayList<>(List.of(1, 2, 2, 3, 4, 4, 5));
        numbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(numbers);

        // 7. Stream from different sources
        int[] numArray = new int[] {1, 2, 3, 4, 5, 6, 7};
        Stream<Integer> integerStream = Arrays.stream(numArray).boxed();    // boxed turns primitive
        integerStream.forEach(System.out::print);                         // ints to object Integer

        // 8. Infinite Streams
        Stream<Integer> infiniteInteger = Stream.iterate(0, n -> n + 1);
        infiniteInteger
                .filter(i -> i % 2 == 0)
                .limit(10)
                .forEach(System.out::println);

        // 9. Combining Streams
        List<String> list1 = Arrays.asList("apple", "banana");
        List<String> list2 = Arrays.asList("cherry", "date");

        Stream<String> combined = Stream.concat(list1.stream(), list2.stream());
        List<String> combinedList = combined.collect(Collectors.toList());
        System.out.println(combinedList);

        // 10. Optional and Streams
        int[] optInput = new int[] {3, 7, 1, 9, 5};
        OptionalInt maxNumber = Arrays.stream(optInput).max();
        maxNumber.ifPresent(value -> System.out.println("Max number : " +value));

        // 11. Custom Operations
        numbers = Arrays.asList(1, 2, 3, 4, 5);
        //Defining the custom collector to calculate the product
        Collector<Integer, int[], Integer> productCollector = Collector.of(
                () -> new int[]{1},             // Supplier: Initialize accumulator with 1
                (arr, num) -> arr[0] *= num,    // Accumulator: Multiply elements into the accumulator
                (arr1, arr2) -> {               // Combiner: Combine accumulators by multiplying their products
                    arr1[0] *= arr2[0];
                    return arr1;
                },
                arr -> arr[0]                   // Finisher: Extract the final product from the accumulator
        );
        int product = numbers.stream()
                .collect(productCollector);
        System.out.println(product);
    }


}