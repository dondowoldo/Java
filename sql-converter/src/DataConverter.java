import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataConverter {

    public static void main(String[] args) {
        String fileName = "src/data.txt";

        boolean[] quoteFlags = {false, true, true, false}; // Adjust as needed

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t");
                StringBuilder formattedData = new StringBuilder("(");

                for (int i = 0; i < data.length; i++) {
                    if (quoteFlags[i]) {
                        formattedData.append("'");
                    }
                    formattedData.append(data[i]);
                    if (quoteFlags[i]) {
                        formattedData.append("'");
                    }

                    if (i < data.length - 1) {
                        formattedData.append(", ");
                    }
                }

                formattedData.append("),");
                System.out.println(formattedData.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}