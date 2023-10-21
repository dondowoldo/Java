import foundation.oop.fruitstore.Color;
import foundation.oop.fruitstore.Fruit;

import java.util.*;
import java.util.stream.Collectors;

public class Lambdas {
    public static void main(String[] args) {
        Color red = new Color(255, 0, 0, "Red");
        Color green = new Color(10, 255, 30, "Green");
        Color blue = new Color(0, 0, 230, "Blue");


        List<Fruit> fruitList = new ArrayList<>(List.of(
                new Fruit(red, "apple", 10),
                new Fruit(green, "mango", 25),
                new Fruit(blue, "blueberry", 30)
        ));

        // Take original list, filter fruits that cost 20 or more and save those into a new list
        List<Fruit> expensive = fruitList.stream().filter(f -> f.getPrice() > 20).collect(Collectors.toList());
        System.out.println(expensive);


        // Map  (The following code segment prints unique squares of numbers using map.)
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.println(squaresList);

        // ForEach
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        System.out.println("-----------------------------");

        // Sorted
        random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);

        // Parallel Stream
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        long count = strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println(count);

        // Statistics
        List<Integer> nums = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = nums.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());
    }
}
