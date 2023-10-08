package foundation.FileManipulationWithOOP;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FileManipulation {
    // you will write a Java program that can read and parse CSV files containing sales data for
    // different regions of a company. You will then perform analysis on the data
    // by implementing three methods: mostProfitableYear, topProducts, and monthlyRevenue.
    // The sales data is stored in CSV files, with each file representing sales data for a
    // different region of the company. Each file has the following
    // columns: "Month"     , "Year",        "Product",      "Units Sold",      "Revenue".

    public static void main(String[] args) {
        System.out.println(mostProfitableYear("east"));

        List<String> topProducts = topProducts("west", 2);
        System.out.println(topProducts);
    }


    public static int mostProfitableYear(String regionName) {
        SalesList listOfSales = new SalesList();
        try {
            listOfSales = extractSales(regionName);
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }

        Map<Integer, Integer> bestYear = new HashMap<>();                           // Create hashmap for each year
        for (Sale s : listOfSales.getListOfSales()) {               // in dataset and sum up revenue for each year
            if (bestYear.containsKey(s.getYear())) {
                bestYear.replace(s.getYear(), bestYear.get(s.getYear()) + s.getRevenue());
            } else {
                bestYear.put(s.getYear(), s.getRevenue());
            }
        }

        int topYear = 0;                                                    // Iterate through the years and save
        for (Map.Entry<Integer, Integer> year : bestYear.entrySet()) {      // the one with the highest revenue
            if (year.getValue() > topYear) {                                // into variable topYear
               topYear = year.getKey();
            }
        }
        return topYear;
    }

    public static List<String> topProducts(String regionName, int n) {
        SalesList listOfSales = new SalesList();
        try {
            listOfSales = extractSales(regionName);
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        Collections.sort(listOfSales.getListOfSales());
        List<String> topProducts = new ArrayList<>();

        int length = Math.min(n, listOfSales.getListOfSales().size());
        for (int i = 0; i < length; i++) {
            if (topProducts.contains(listOfSales.getListOfSales().get(i).getProduct())) {
                n++;
            } else {
                topProducts.add(listOfSales.getListOfSales().get(i).getProduct());
            }
        }
        return topProducts;
    }

    public static Map<String, Integer> monthlyRevenue(String regionName, int year) throws FileNotFoundException {

        return new HashMap<>();
    }



    public static SalesList extractSales(String regionName) throws FileNotFoundException {
        Path filePath = Paths.get(regionName + ".csv");
        SalesList listOfSales = new SalesList();

        if (!Files.exists(filePath)) {
            throw new FileNotFoundException(String.format("Cannot find sales data for %s, please try again", regionName));
        }

        try {
            List<String> fileContent = Files.readAllLines(filePath, UTF_8);
            fileContent.remove(0);                                          // Remove the titles from dataset
            for (String row : fileContent) {
                String[] category = row.split(",");                 // Separate each value by comma
                listOfSales.add(new Sale(                                 // Add Sale into the list of all sales
                                category[0],
                                Integer.parseInt(category[1]),
                                category[2],
                                Integer.parseInt(category[3]),
                                Integer.parseInt(category[4])
                        )
                );
            }

        } catch (IOException e) {
            System.err.println("Error: Unable to read file");
        }
        return listOfSales;
    }
}
