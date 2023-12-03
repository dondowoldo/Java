package finalex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SecondBiggest {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(1, 5, 23, 49, 19, 1, 15));

        int result1 =findSecondBiggest1(numbers);
        int result2 = findSecondBiggest2(numbers);
        int result3 = findSecondBiggest3(numbers);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    private static int findSecondBiggest1(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers.get(numbers.size() - 2);
    }

    private static int findSecondBiggest2(List<Integer> numbers) {
        int biggest = numbers.get(0);
        int secondBiggest = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > biggest) {
                secondBiggest = biggest;
                biggest = numbers.get(i);
            } else if (numbers.get(i) > secondBiggest && numbers.get(i) != biggest) {
                secondBiggest = numbers.get(i);
            }
        }
        return secondBiggest;
    }
    public static int findSecondBiggest3(List<Integer> numbers) {
        numbers.sort(Comparator.comparingInt(Integer::intValue).reversed());
        return numbers.get(1);
    }
}
