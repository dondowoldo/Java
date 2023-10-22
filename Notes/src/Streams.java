import utilclasses.People;
import utilclasses.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        // example list // all people have name, age and gender (String, int, String)
        List<Person> people = new People().instantiatePeople().getPeople();
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        /*      STREAMS
        - nejčastěji využívané pro kolekce (Array, Set, List, Map,..)
        - voláme jako : List : list.stream() , Array : Arrays.stream(myArray)
            pozn. Když chceme Stream characterů ze stringu, zavoláme na string metodu .chars() která vrací IntStream,
                    jehož hodnoty představují ASCII hodnoty characterů.
                    Pokud tedy potom chceme zpátky character, musíme použít mapToObj() metodu a vrátit (char)


                                // Metody
        ## INTERMEDIATE ## - Transformují nebo filtrují data při průchodu streamem.
                           -Lazy metody. Sami o sobě nic nedělají, potřebujeme aby se stream pohyboval, čehož
                                                                            docílíme pomocí terminálních metod.
            - patří mezi ně :
                    filter(Predicate predicate) - Filtruje prvky na základě zadané podmínky.
                    map(Function mapper) - Mapuje prvky na jiné hodnoty pomocí zadané funkce.
                    mapToInt() - Aplikuje "mapper" funkci na každý prvek a vrátí nový IntStream (primitivních intů)
                    flatMap(Function mapper) - Mapuje prvky na streamy a spojuje je do jednoho streamu.
                    distinct() - Odstraní duplikáty ze streamu.
                    sorted() - Seřadí prvky ve streamu podle přirozeného pořadí.
                    sorted(Comparator comparator) - Seřadí prvky ve streamu podle komparátoru.
                    peek(Consumer action) - Umožňuje provádět vedlejší operace na prvcích streamu, aniž by stream modifikovali.
                    limit(long maxSize) - Omezí počet prvků ve streamu na zadaný počet.
                    skip(long n) - Přeskočí prvních n prvků ve streamu.
                    parallel() - Převede sekvenční stream na paralelní stream.
                    unordered() - Odstraní pořadí prvků ve streamu.

        ## TERMINAL ##     - Metody, které "rozpohybují" stream. Jakmile terminální metodu zavoláme, stream se
                                spotřebuje a nemůžeme ho použít znovu.
            - patří mezi ně :
                    forEach(Consumer action) - Provádí zadanou akci pro každý prvek streamu.
                    toArray() - Převede prvky streamu na pole.
                    reduce(identity, accumulator) - Redukuje prvky streamu na jednu hodnotu.
                    collect(Collector collector) - Shromažďuje prvky streamu do kolekce.
                    min(Comparator comparator) - Najde minimální prvek ve streamu.
                    max(Comparator comparator) - Najde maximální prvek ve streamu.
                    count() - Vrátí počet prvků ve streamu jako long.
                    anyMatch(Predicate predicate) - Vrátí true, pokud alespoň jeden prvek streamu splňuje podmínku.
                    allMatch(Predicate predicate) - Vrátí true, pokud všechny prvky streamu splňují podmínku.
                    noneMatch(Predicate predicate) - Vrátí true, pokud žádný prvek streamu nesplňuje podmínku.
                    findFirst() - Vrátí první prvek streamu jako Optional.
                    findAny() - Vrátí libovolný prvek streamu jako Optional.

        Příklady :

                .map()
    */                  System.out.println("Přičti ke kazdému prvku z listu čísel \"3\" a vrať výsledek do nového listu");

                        List<Integer> numbersPlusThree = numbers.stream()
                                .map(n -> n + 3)
                                .collect(Collectors.toList());
                        System.out.println(numbersPlusThree);

                        System.out.println();



        //      .mapToInt()
                        System.out.println("Vrať maximální věk(pouze) z listu lidí");

                        OptionalInt age = people.stream()
                                        .mapToInt(p -> p.getAge())      //To samé jako .mapToInt(Person::getAge)
                                        .max();                 // vrátí optional int (může a nemusí tam být)
                        int maxAge = age.orElse(-1);      // uložíme výsledek opt intu a pokud tam není tak -1
                        System.out.println(maxAge);

                        System.out.println();

        //      .peek()   // poznámka: Následným násobením už měníme stream pomocí metody .map() . Po peeku se nic nemění.
                        System.out.println("Projeď list čísel, vytiskni prvek, následně vynásob \"2\" a vytiskni znovu.");

                        numbers.stream()
                                .peek(n -> System.out.print(n + " | "))
                                .map(n -> n * 2)
                                .forEach(System.out::println);

                        System.out.println();

        //      .filter()
                        System.out.println("Z listu lidí, vyber lidi kteří jsou mladší než 27 a ulož do nového listu");
                        List<Person> peopleUnder27 = people.stream()
                                .filter(p -> p.getAge() < 27)
                                .collect(Collectors.toList());
                        System.out.println(peopleUnder27);

                        System.out.println();


        //      .groupingBy()
                        System.out.println("Shromáždi lidi podle věku");
                        Map<Integer, List<Person>> peopleByAge = people.stream()
                                .collect(Collectors.groupingBy(p -> p.getAge()));
                        System.out.println(peopleByAge);

                        System.out.println();

                        System.out.println("Shromáždi počet lidí v daném věku");
                        Map<Integer, Long> peopleAgeCount = people.stream()
                                .collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
                        System.out.println(peopleAgeCount);   // Pokud potřebujeme Integer a ne Long,
                                                            // můžeme použít metodu summingInt(n -> 1) místo .counting()
                        System.out.println();

                        System.out.println("Rozděl lidi do dvou skupin : 25 let a mladší || 26 let a starší");
                        Map<Boolean, List<Person>> peopleDivision = people.stream()
                                .collect(Collectors.partitioningBy(p -> p.getAge() <= 25));
                        System.out.println(peopleDivision);

                        System.out.println();

                        System.out.println("Spočti počet lidí ze dvou skupin : 30 let a mladší || 31 let a starší");
                        Map<Boolean, Long> peopleDividedCount = people.stream()
                                .collect(Collectors.partitioningBy(p -> p.getAge() <= 30, Collectors.counting()));
                        System.out.println(peopleDividedCount);

                        System.out.println();

                        System.out.println("Rozděl lidi do skupin: \" <=35 years a \">35 years\"");
                        Map<String, Integer> ageGroups = people.stream()
                                .collect(Collectors.groupingBy(p -> p.getAge() <= 35 ? "35years and under" : "36 years and over",
                                            Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
                                                                            // by using collectingAndThen we can convert
                                                                            // Long into and Integer
                        System.out.println(ageGroups);

                        System.out.println();

                        System.out.println("Rozděl lidi do skupin: 35 years and under - male/female || over 35 - male/female ");
                        Map<String, Integer> moreAgeGroups = people.stream()
                                .collect(Collectors.groupingBy(p -> {
                                    if (p.getAge() <= 35) {
                                        if (p.getGender().equals("male")) {
                                            return "(MALES) 35 years and under";
                                        } else {
                                            return "(FEMALES) 35 years and under";
                                        }
                                    }
                                    if (p.getAge() > 35) {
                                        if (p.getGender().equals("male")) {
                                            return "(MALES) 36 years and over";
                                        } else {
                                            return "(FEMALES) 36 years and over";
                                        }
                                    }
                                    return "Nonhuman";
                                }, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
                                System.out.println(moreAgeGroups);

                                System.out.println();



    }
}


