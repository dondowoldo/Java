import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class File {
  public static void main(String[] args) throws IOException {
    String fileName = "mujSoubor.dada";
    Path path = Path.of(fileName);
    if (!Files.exists(path)) {
      try {
        Files.createFile(path);
      } catch (IOException e) {
        System.out.println("Can not create file at " + path.toAbsolutePath());
      }
    }
    try {
      List<String> content = new ArrayList<>();
      for (int i = 0; i < 5; i++) {
        content.add("Lukáš Kubec");
      }
      Files.write(path, content);
    } catch (FileNotFoundException e) {
      System.out.println("Nenašel jsem soubor kam zapsat");
    } catch (IOException e) {
      System.out.println("Neumím psát");
    }

    List<String> loadedContent = Files.readAllLines(path);
    for (String name : loadedContent) {
      System.out.println(name);
    }

    String loadedAsOneString = Files.readString(path);
    System.out.println(loadedAsOneString);

  }
}
