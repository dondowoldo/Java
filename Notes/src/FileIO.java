import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
// IMPORTANT COMMANDS TO KNOW :
// 1. Path somePath = Paths.get("src/someCSVfile.csv")     = Converts string into a Path and saves into variable "somePath".
// 2. List<String> fileLines = Files.readAllLines(somePath, UTF_8) = Saves all lines from csv file into an ArrayList "fileLines"
// 3. fileLines.remove(index) = removes a row from an ArrayList on given index (0 usually for titles for values, etc..)


// READ A FILE STEP BY STEP:
//      a) We should create a method like "readFile" that takes a path to a file we want to read as its parameter.
//      b) We can than call "readFile" method and pass in a String with the filepath (where the file is located)
//      c) We need to convert this String into a Path using: " Path filepath = Paths.get(file) " where filepath = passed in
//                                                                                               String from step (b).
//      d) We can call " Files.readAllLines(filepath, UTF_8) " where filepath is a path from step (c) and UTF_8 is
//                                                          an optional argument representing coding (UTF_8 is recommended though)
//      e) Save the function call from step (d) into a List. eg. "List<String> fileLines = Files.readAllLines(filepath, UTF_8);"
//      f) The "readFile" method should return an ArrayList.

// NOTE: Everytime we try to read/write/append a file. We need to handle exceptions that may occur as a result of an invalid file,
//       or invalid data in the file. We handle exceptions using "try" and "catch" blocks. We can either use a general Exception, or
//       we can create Exceptions of our own with unique properties. (More on Exceptions in InvalidPokemon..java classes)

// MANIPULATE DATA STEP BY STEP:
//      a) Now that we successfully saved our csv file into an ArrayList "fileLines", we can extract just the data we need.
//      b) We should create a new method for the extraction. In this case we are getting names so we create "getNames" method.
//         that takes an ArrayList (in our case: fileLines) as its parameter.
//      c) "fileLines" ArrayList now holds all the values on each row (eg. ,Bulbasaur,Grass,Poison,318,45,49,49,65,65,45,1,False)
//          as ONE string. In order to get particular data out, we need to separate the values. We can do that with a split method:
//      d) In our new "getNames" method we create new ArrayList where we want to store our names.
//      e) We then iterate through the Array fileLines using a forloop for (i = 0; i < fileLines.length(); i++) and
//          inside a forloop we create a new String : String name = fileLines.get(i) // to get the entire ith row of data in one string.
//      f) We then need to separate the values so we create a new Array: String[] data = fileLines.split(",")   // where the comma "," is
//                                                                                                                 the separator.
//      g) We can than create a new String that will hold solely the name : String nameString = data[1]   // index 1 in this case, because
//                                                                   names are on the second place separated by the ",".
//      h) Once we have the name, we can add it to our ArrayList from step (d) using: namesList.add(nameString);

// WRITE INTO A FILE / APPEND A FILE STEP BY STEP:
//
//              WRITE:
//      a) Again we create our own method for writing into a file that takes an ArrayList of values(names)  and a String of
//              the path of our final file containing names as its parameters. (eg. "src/pokemonNames.csv")
//      b) We use commands Files.write(Paths.get(file), fileContent)  , where file = path string ("src/pokemonNames.csv") and
//                                                                           fileContent = our ArrayList of names.
//              APPEND:
//      We use exactly the same process but we add one more argument into the Files.write method call
//      "  Files.write(Paths.get(file), fileContent, StandardOpenOption.APPEND); "

public class FileIO {
    public static void main(String[] args) {
        List<String> pokemons = readFile("src/pokemons.csv");

        try {
            validateContent(pokemons);
        } catch (InvalidPokemonTotalException e) {
            System.err.println("Invalid Total");
            System.exit(1);                     // If we want to terminate the program after exception
        } catch (InvalidPokemonTypeException e) {
            System.err.println("Invalid Type.");
            System.exit(2);
        } catch (Exception e) {                         // The most general exceptions SHOULD go to the end, as
            System.err.println("Unknown Error");        // only the first exception that meets the criteria
            System.exit(3);                      // will get triggered.
        } finally {
            System.out.println("Validation ended.");    // "Finally" block will get executed no matter if we
        }                                               // triggered an exception or not. It will NOT run however,
                                                        // if we exit the program prematurely ("System.exit()")

        List<String> pokemonNames = filterPokemonNames(pokemons);
        writeFile(pokemonNames, "src/pokemonNames.csv");
        System.out.println(pokemonNames);
        appendFile(Arrays.asList("Append Test # 1", "Append Test # 2"), "src/pokemonNames.csv");
    }

    private static void validateContent(List<String> pokemons)
            throws InvalidPokemonTotalException, InvalidPokemonTypeException {
        for (String pokemon : pokemons) {
            String[] pokemonData = pokemon.split(",");
            int total = Integer.parseInt(pokemonData[4]);
            String type1 = pokemonData[2];
            String type2 = pokemonData[3];
            if (total < 0)  {
                throw new InvalidPokemonTotalException();
            } else if (type1.isEmpty() && type2.isEmpty()) {
                throw new InvalidPokemonTypeException();
            }
        }
    }

    private static void appendFile(List<String> fileContent, String file) {
        try {
            Files.write(Paths.get(file), fileContent, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Unable to write file.");
        }
    }

    private static void writeFile(List<String> fileContent, String file) {
        try {
            Files.write(Paths.get(file), fileContent);
        } catch (IOException e) {
            System.err.println("Unable to write file.");
        }
    }

    public static List<String> readFile(String file) {
        Path filepath = Paths.get(file);                                         // UTF_8 argument is a type of coding.
        try {                                                                    // Not mandatory argument but is good practice
            List<String> fileLines = Files.readAllLines(filepath, UTF_8);        // as default coding may not get some special characters correctly
            fileLines.remove(0);     // removes the very first line(usually titles for values stored)
            return fileLines;
        } catch (IOException e) {
            System.err.println("Unable to read this file.");
            return new ArrayList<>();
        }
    }

    public static List<String> filterPokemonNames (List<String> pokemons) {
        List<String> pokemonNames = new ArrayList<>();

        for (int i = 0; i < pokemons.size(); i++) {
            String pokemonLine = pokemons.get(i);
            String[] pokemonData = pokemonLine.split(",");
            String pokemonName = pokemonData[1];
            pokemonNames.add(pokemonName);
        }
        return pokemonNames;
    }




}