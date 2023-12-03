package finalex;

public class Anagram {
    public static void main(String[] args) {

        String s1 = "silent";
        String s2 = "listen";

        System.out.println(isAnagram(s1, s2));
    }

    private static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            int index = s2.indexOf(s1.charAt(i));
            if (index == -1) {
                return false;
            }
            s2 = s2.substring(0, index) + (s2.substring(index + 1));
        }
        return true;
    }
}
