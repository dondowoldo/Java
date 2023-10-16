import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DecryptCipher {
    public static void main(String[] args) {
        String text = "OR FHER GB QEVAX LBHE BINYGVAR";

        System.out.print(decrypt(text));
    }

    // takes an int parameter as to how many rotations should be done
    public static String encrypt(String s, int rotation) {
        int[] intValueChars = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            int intValue = (int)s.charAt(i);
            if (intValue >= 65 && intValue <= 90) {
                intValueChars[i] = (intValue - 65 + rotation) % 26 + 65;
            } else if (intValue >= 97 && intValue <= 122) {
                intValueChars[i] = (intValue - 97 + rotation) % 26 + 97;
            }
            else {
                intValueChars[i] = s.charAt(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intValueChars.length; i++) {
            sb.append(Character.toChars(intValueChars[i]));
        }
        return sb.toString();
    }

    // Takes a ciphered text as input and tries to rotate characters. If at least half of the
    // words are real words, it will return that deciphered String (more than 1 possible)
    public static String decrypt(String cipheredText) {
        Path filePath = Paths.get("words.txt");
        List<String> fileContent = new ArrayList<>();
        List<String> words = new ArrayList<>();
        StringBuilder possibleText = new StringBuilder();

        try {
            fileContent = Files.readAllLines(filePath);
        } catch (IOException e) {
            System.err.println("Unable to read");
            return null;
        }

        for (String row : fileContent) {
            String[] rowSplit = row.split("\t");
            for (String separated : rowSplit) {
                words.add(separated.trim());
            }
        }

        int wordCount = cipheredText.split(" ").length;
        int[] intValues = new int[cipheredText.length()];

        for (int i = 0; i < 26; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < cipheredText.length(); j++) {
                int currentCharInt = (int) cipheredText.charAt(j);

                if (currentCharInt >= 65 && currentCharInt <= 90) {
                    intValues[j] = (currentCharInt - 65 + i) % 26 + 65;
                } else if (currentCharInt >= 97 && currentCharInt <= 122) {
                    intValues[j] = (currentCharInt - 97 + i) % 26 + 97;
                } else {
                    intValues[j] = currentCharInt;
                }
                sb.append(Character.toChars(intValues[j]));
            }
            String phrase = sb.toString();
            String[] separatedWords = phrase.split(" ");

            int countValidWords = 0;
            for (int k = 0; k < separatedWords.length; k++) {
                if (words.contains(separatedWords[k].toLowerCase())) {
                    countValidWords++;
                }
            }
            if (countValidWords >= wordCount / 2) {
                possibleText.append(phrase).append("\n");
            }
        }
        return possibleText.toString();
    }
}
