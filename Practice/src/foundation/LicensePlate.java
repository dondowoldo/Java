package foundation;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.charset.StandardCharsets.UTF_8;

//if the licence plate starts with a vowel, the word also has to start with the same vowel
//if it starts with a consonant, it can start with any vowel but after the vowel(s) this consonant should come
//after vowels if the next letter on the licence plate is a consonant then this consonant should come as next, if the next letter
//on the licence plate is a vowel other consonants can come between them
//after consonants if the next letter on the licence plate is a consonant then any vowel(s) can come between them but if the
//next character in the licence plate is a vowel then no other letter can come between them
//the licence plate can contain a 2-5 letter long string and no numeric values, only alphabetical

public class LicensePlate {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        try {
            words = readFile("words");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a license plate (2-5 letters):");
        String userInput = scanner.nextLine();



        // TODO WRONG REGEX - NOT WORKING AS INTENDED FOR NOW

        String regex = "^(?i)([aeiou])[a-z]{1,5}\\1$|(?i)([bcdfghjklmnpqrstvwxyz])[aeiou]+\\2[a-z]*|(?i)([bcdfghjklmnpqrstvwxyz])[a-z]*[aeiou]\\3[a-z]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;


        List<String> result = new ArrayList<>();
        for (String s : words) {
            matcher = pattern.matcher(s);
            if (matcher.matches()) {
                result.add(s);
            }
        }
        System.out.println(result);
    }
        // TODO WRONG REGEX - NOT WORKING AS INTENDED FOR NOW






    public static List<String> readFile(String fileName) throws FileNotFoundException {
        Path filePath = Paths.get(fileName + ".txt");
        if (!Files.exists(filePath)) {
            throw new FileNotFoundException("Invalid file");
        }

        List<String> fileContent = new ArrayList<>();
        List<String> words = new ArrayList<>();
        try {
            fileContent = Files.readAllLines(filePath, UTF_8);
        } catch (IOException e) {
            System.err.println("Unable to read file");
        }
        for (String row : fileContent) {
            String[] separated = row.split("\t");
            for (String s : separated) {
                words.add(s.trim());
            }
        }
        return words;
    }
}
