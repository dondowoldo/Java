package foundation;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class StringsAndFiles {
    // #1   Write a function, that accepts string as a parameter and return
    //      length of the longest word in that string.

    // #2   Modify the given function so it accepts inputFile path and outputFile path as a parameter instead
    //      of a string. inputFile is a path to a file as a string that include string/text that will be used as a
    //      source (so you will read it) and outputFile is a path to a file as a string where you should write the result
    // of given function - so no return is requested, only read from file, calculate, write to file.
    // The method should print Error: Can not manipulate file - original error message: <message> - is the original message
    // from the error/exception that happened.

    public static void main(String[] args) {

        // # Step 1
        String test = "Hello there! General Kenobi?";
        System.out.println(longestWord(test));

        // # Step 2

        longestWord("stringsAndFilesInput.txt", "stringsAndFilesOutput.txt");
    }

    public static int longestWord(String sentence) {
        int maxLength = 0;
        for (String word : sentence.split("[,. ]")) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }
        return maxLength;
    }

    public static void longestWord(String input, String output) {
        int maxLength = 0;
        Path inputPath = Paths.get(input);
        Path outputPath = Paths.get(output);

        try {
            List<String> fileLines = Files.readAllLines(inputPath, UTF_8);
            for (String row : fileLines) {
                String[] rowPlain = row.split("[,. ]");
                for (String word : rowPlain) {
                    if (word.length() > maxLength) {
                        maxLength = word.length();
                    }
                }
            }
            Files.writeString(outputPath, String.valueOf(maxLength), UTF_8);

        } catch(IOException e) {
            System.err.println("Error: Can not manipulate file - original error message: " + e);
        }
    }
}
