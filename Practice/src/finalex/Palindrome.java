package finalex;

public class Palindrome {
    public static void main(String[] args) {
        String s = "kajak";

        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return true;
        }
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return isPalindrome(s.substring(1, s.length() - 1));
        }
        return false;
    }

    private static boolean isPalindrome2(String s) {
        int index = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            if (index <= i) return true;
            if (s.charAt(i) != s.charAt(index)) {
                return false;
            }
            index--;
        }
        return false;
    }
}
