import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//      READ:
// 1.   List<String> addresses = readFile("src/addresses.csv"); --> passed to reader method as path

// 2.   a) Reader method - > Path filePath = Paths.get(path);
//      b) List<String> reader = Files.readAllLines(filePath); --> return as List

// 3.   a) List<String> firstNames = new ArrayList<>();
//      b) forloop through addresses and add to List desired values --> String[] rowData = addresses.get(i).split(",");
//                                                                      firstNames.add(rowData[0]);
//      c) return as list


public class FileIO {
    public static void main(String[] args) {
        List<String> addresses = readFile("src/addresses.csv");
        System.out.println(addresses.get(0));
        List<String> firstNames = getFirstNames(addresses);
        System.out.println(firstNames);
    }

    private static List<String> getFirstNames(List<String> addresses) {
        List<String> firstNames = new ArrayList<>();
        for (int i = 0; i < addresses.size(); i++) {
            String[] rowData = addresses.get(i).split(",");
            firstNames.add(rowData[0]);
        }
        return firstNames;
    }

    public static List<String> readFile(String path) {
        Path filePath = Paths.get(path);
        try {
            List<String> reader = Files.readAllLines(filePath);
            return reader;
        } catch (IOException e) {
            System.err.println("Unable to read.");
            return new ArrayList<>();
        }
    }
}