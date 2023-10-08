package foundation;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

public class MapsAndFiles {
    // Write a calculateSalesStats function that reads and parses a file containing sales
    // data for different products.
    // The method takes a string filePath as a parameter.
    // The sales data is given in 3 columns, separated by a comma (csv):
    // product, unitsSold, revenue

    // The method should return a map/dictionary containing the following statistics for all products:
    //      totalRevenue: total revenue for all products
    //      totalUnits: total units sold for all products
    // If the file is not found, it should throw an exception with the following message: File not found: filename
    // If the file is empty, the output should be null.

    public static void main(String[] args) {
        try {
            System.out.println(calculateSalesStats("example.txt"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static Map<String, Integer> calculateSalesStats(String path) throws IOException {
        Path filePath = Paths.get(path);
        if (!Files.exists(filePath)) {
            throw new IOException("File not found: " + path);
        } else if (Files.size(filePath) == 0) {
            return null;
        }

        Map<String, Integer> totals = new HashMap<>(Map.of(
                "totalRevenue", 0,
                "totalUnits", 0
        ));

        List<String> fileLines = Files.readAllLines(filePath, UTF_8);
        for (String row : fileLines) {
            String[] values = row.split(",");
            totals.replace("totalRevenue", totals.get("totalRevenue") + Integer.valueOf(values[2]));
            totals.replace("totalUnits", totals.get("totalUnits") + Integer.valueOf(values[1]));
        }
        return totals;
    }
}
