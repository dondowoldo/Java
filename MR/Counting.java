import java.util.Random;

public class Counting {

    public static void main(String[] args) {
        //System.out.println(reverseString("ahoj".repeat(20000)));
        //System.out.println(reverseString2("ahoj".repeat(2000000) + "):"));
        //System.out.println(reverseString3("abcdef"));
        System.out.println(fib(50));
    }

    public static int fib(int index) {
        if (index < 2) {
            return index;
        }

        return fib(index - 1) + fib(index - 2);
    }

    public static String reverseString3(String s) {
        if (s.length() < 2) {
            return s;
        }

        String left = s.substring(0, s.length() / 3);
        String center = s.substring(s.length() / 3, s.length() * 2 / 3);
        String right = s.substring(s.length() * 2/ 3);

        return reverseString3(right) + reverseString3(center) + reverseString3(left);
    }

    public static String reverseString2(String s) {
        if (s.length() < 2) {
            return s;
        }

        String left = s.substring(0, s.length() / 2);
        String right = s.substring(s.length() / 2);

        return reverseString2(right) + reverseString2(left);
    }
    public static String reverseString(String s) {
        if (s.length() < 2) {
            return s;
        }

        return reverseString(s.substring(1)) + s.charAt(0);
    }

    public static void recursiveDumb(int i) {
        if (i < 0) {
            return;
        }
        System.out.println(i);
        recursiveDumb(i-1);
    }
}
