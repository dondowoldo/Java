import java.util.*;

public class DataStructures {
    public static void main(String[] args) {

        // ######### DATA STRUCTURES ###########

        //////////////////////////////// ARRAYS (fixní velikost, primitivní datové typy / referenční datové typy)

        int[] mujArray = new int[2];                        // Prazdný array o velikosti 2
        int[] mujArray2 = new int[]{1, 2};                 // Array o velikosti 2 s prvky {1,2} na indexech 0 a 1
        int a = mujArray2[1];                               // Uloží prvek na indexu 1 (2. pozice) do proměnné "a"
        int b = mujArray2.length;                           // Uloží počet prvků v arrayi do proměnné "b"

        // Manipulace
        int[] mujArray3 = new int[]{1, 2, 3, 4, 5};
        int[] copyArray = Arrays.copyOf(mujArray3, mujArray3.length); // Vytvoří nový array, který je kopií starého
        int[] modifyArray = Arrays.copyOf(mujArray3, mujArray3.length - 1); /* Vytvoří kopii starého Arraye, ale s délkou
                                                                                        o 1 menší než původní = Vynechá poslední prvek */

        int[] modifyAgain = Arrays.copyOfRange(mujArray3, 1, 3);    /* Vytvoří kopii starého arraye, ale pouze v rozmezí
                                                                                indexů 1-3 (včetně počátečního prvku, ale VYJMA konečného!!)
                                                                                                                                     */
        System.out.println(mujArray2);                      // Vytiskne hash kde v paměti je uložený array (něco jako [I@6acbcfc0)
        System.out.println(Arrays.toString(mujArray2));     // Převede výstup arraye na String a vytiskne prvky [1, 2]

        //////////////////////////////// 2D ARRAYS ////////////////////////////////

        int[][] matrix = new int[2][3];                     //          [0,0][0,1][0,2]
                                                            //          [1,0][1,1][1,2]

        int[][] matrixFilled = new int[][]{                   //          [0,0][0,1][0,2]
                {1, 2, 3},                                    //          [1,0][1,1][1,2]
                {4, 5, 6},                                    //          [2,0][2,1][2,2]
                {7, 8, 9}                                     //
        };

        int[][] matrixLoop = new int[3][4];                             // Příklad jak naplnit 2D array hodnotami z
        int[] values = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};      // klasického arraye pomocí proměnné valueIndex, kterou
        int valueIndex = 0;                                             // posouváme o 1 kdykoli přidáme hodnotu do 2D arraye.

        for (int i = 0; i < matrixLoop.length; i++) {                   //      2D array pak bude vypadat takto:
            for (int j = 0; j < matrixLoop[i].length; j++) {            //      [1][2][3][4]
                if (valueIndex < values.length) {                       //      [5][6][7][8]
                    matrixLoop[i][j] = values[valueIndex];              //      [9][10][11][12]
                    valueIndex++;
                }
            }
        }

        //////////////////////////////// LIST /////////////////////////// (flexibilní velikost, pouze referenční typy data)

        List<String> listStringu = new ArrayList<>();               // Deklaruje a zároveň inicializuje nový prázdný list
        // který bude v sobě mít elementy typu String

        String[] arrayStringu = new String[]{"Dan", "Honza", "Jana", "Tomas"};
        List<String> listZArraye = new ArrayList<>(List.of(arrayStringu));          // Jak z arraye Stringů udělat nový List<String>.

        List<Integer> listHodnot = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));       // Deklarace + Inicializace nového listu typu Integer
        // do kterého rovnou vložíme hodnoty.

        // Poznámka: Pokud máme List<Integer> a chtěli bychom do něj vložit array hodnot typu int (primitive), nemůžeme
        //           použít "List.of" metodu výše kvůli odlišnému typu dat. Musíme tedy použít for loop.
        // viz příklad níže :

        List<Integer> listHodnot2 = new ArrayList<>();

        // z 2D arraye foreach loopem(pouze příklad. Můžeme použít i klasický for i loop) | // Z klasického arraye :
        for (int[] row : matrixLoop) {                                                      // for (int i = 0; i < values.length; i++) {
            for (int value : row) {                                                         //      listHodnot2.add(values[i])
                listHodnot2.add(value);                                                     // }
            }
        }

        int d = listHodnot2.get(2);                                 // Vytáhne prvek z listu na indexu "2" a uloží do proměnné "d"
        listHodnot2.remove(2);                                // Odstraní prvek z listu na indexu "2"
        listHodnot2.add(5);                                         // Přidá "5" na konec listu
        listHodnot2.add(1, 5);                        // Přídá "5" na index 1 v listu a posune zbytek
        listHodnot2.addAll(listHodnot);                             // Přidá do listu všechny prvky z jiné kolekce
        listHodnot2.size();                                         // Vrátí počet prvků v listu (ekvivalent .length u arrayů)
        listHodnot2.isEmpty();                                      // Vrátí boolean true, pokud je list prázdný. Jinak false.
        listHodnot2.contains(14);                                   // Vrátí boolean true pokud se daný element nachází v listu. Jinak false.
        listHodnot2.containsAll(listHodnot);                        // Vrátí boolean true pokud list obsahuje všechny prvky z jiné kolekce.
        //listHodnot2.clear();                                      // Kompletně vymaže všechny prvky z listu

        List<Integer> subListCAREFUL = listHodnot2.subList(0, 5);   // Vrátí pohled na sublist z původního listu, mezi indexy
                                                                    // spodní index - inclusive , vrchní index - exclusive !!
                                                                    // POZOR !! Nevytváří nový list. Pokud subList změníme, změny se
                                                                    // projeví i v originále. Pokud chceme list nový, musíme použít "new"

        List<Integer> subListNEW = new ArrayList<>(listHodnot2.subList(0, 5)); // Příklad vytvoření nového sublistu, který můžeme měnit
                                                                                // bez následků v originále.

        listHodnot2.indexOf(8);                                     // Vrátí index, na kterém se nachází daný prvek (-1 pokud tam není)
        listHodnot2.lastIndexOf(10);                                // Vrátí index posledního výskytu daného prvku (-1 pokud tam není)


        //////////////////////////////// HASHMAP //////////////////////////////// (Ukládá dvojice "klíč" a "hodnota" , referenční typy)

        Map<String, String> praha = new HashMap<>();           // Deklarace + Inicializace nové prázdné hashmapy

        Map<String, Integer> nakup = new HashMap<>(Map.of(      // Vytvoření nové HashMapy a vložení klíčů a hodnot
                "mliko", 2,                                     // rovnou při inicializaci pomocí metody Map.of()
                "vejce", 12,
                "chleba", 1
        ));

        nakup.put("maslo", 3);                                 // Přidá do mapy další pár (k+v)
        nakup.size();                                          // Vrací počet párů v mapě
        nakup.get("vejce");                                    // Vrátí hodnotu záznamu s klíčem "vejce"
        nakup.remove("chleba");                           // Vymaže celý záznam s klíčem "chleba"


        nakup.replace("mliko", 4);                             // Přepíše hodnutu záznamu s klíčem "mliko" na novou

        nakup.replace("mliko", 4, 1);     // Vrací boolean. Přepíše hodnotu záznamu s klíčem "mliko" na novou, ale pouze
                                                                // v případě, že se původní hodnota shoduje. Jinak záznam nezmění,
                                                                // a metoda vrátí boolean false.

        nakup.containsKey("rohlik");                            // Vrací boolean true, pokud Mapa obsahuje záznam s klíčem "rohlik". Jinak false
        nakup.values();                                         // Vrací kolekci všech hodnot [12, 1, 3] v Mapě. Ale nevíme, k čemu patří
        nakup.keySet();

        nakup.keySet();                                         // Vrací set všech klíčů v mapě [vejce, mliko, maslo]
        nakup.entrySet();                                       // Vrací set párů [vejce=12, mliko=1, maslo=3]

        // Poznámka: Do HashMap nemůžeme indexovat. Prvky totiž mohou mít vždy různé pořadí.
        // Poznámka 2: Pro vyhledání záznamu podle klíče můžeme použít metodu get. Pokud ale chceme vyhledat
        //              záznam podle hodnoty, musíme použít loop a iterovat celým entry setem než hodnotu najdeme.


        Map<String, Integer> docasnaMapa = new HashMap<>();

        // příklad : Chceme najít záznam, který má hodnotu 3 a potom případně pouze klíč nebo přidat celý záznam do nové mapy.

        for (Map.Entry zaznam : nakup.entrySet()) {
            if (zaznam.getValue().equals(3)) {
                System.out.println(zaznam);                                                  // vytiskne celý záznam
                System.out.println(zaznam.getKey());                                         // vytiskne klíč
                docasnaMapa.put(zaznam.getKey().toString(), (Integer) zaznam.getValue());    // přidá záznam do jiné mapy
            }
        }

        //////////////////////////////// KOMBINACE DATOVYCH STRUKTUR ////////////////////////////////

        // pouze příklady

        // 1. HASHMAPA HASHMAP (nakupni seznam pro Honzu a Janu)
        Map<String, Integer> honzaNakup = new HashMap<>(Map.copyOf(nakup));         // Vytvoříme si individuální nákup. seznamy
        Map<String, Integer> janaNakup = new HashMap<>(Map.copyOf(nakup));  // (Jsou stejné protože jde o příklad. Každý by měl mít svůj)


        Map<String, Map<String, Integer>> nakupProVicLidi = new HashMap<>(Map.of(       // Vytvoříme novou Hashmapu a zadáme klíče + hodnoty
                "Honza", honzaNakup,
                "Jana", janaNakup
        ));

                // ( Alternativní způsob přidání pokud samotné nákupy nemáme ve vlastní mapě : )
         /*
                                     Map<String, Map<String, Integer>> nakupProVicLidi = new HashMap<>(Map.of(
                                             "Honza", Map.of(
                                                     "mliko", 4,
                                                     "chleba", 1
                                                    ),
                                             "Jana", Map.of(
                                                     "mliko", 2,
                                                     "vejce", 12
                                                    )
                                             ));
          */


        int pocetMlika = nakupProVicLidi.get("Honza").get("mliko");             // Vrací počet mlíka pro Honzu a ukládá do proměnné
        System.out.println(pocetMlika);


        // 2. HASHMAPA LISTŮ
        // příklad : Dan a Honza psali každý den test z matematiky. pondělí = 0 index, pátek = 4 index.
        //          chceme najít první danovu známku a zjistit který den dostal Honza z testu čtyřku.

        List<Integer> znamkyDan = new ArrayList<>(List.of(3,3,2,2,5));          // Vytvoříme si listy známek
        List<Integer> znamkyHonza = new ArrayList<>(List.of(2,2,3,1,4));

        Map<String, List<Integer>> znamkyZMatematiky = new HashMap<>();         // Vytvoříme prázdnou HashMapu

        znamkyZMatematiky.put("Dan", znamkyDan);                                // Vložíme listy známek do Mapy
        znamkyZMatematiky.put("Honza", znamkyHonza);

        int danPrvniZnamka = znamkyZMatematiky.get("Dan").get(0);               // Tiskneme první Danovu známku z Matematiky
        System.out.println(danPrvniZnamka);


            // 2. ČÁST
        Map<Integer, String> dnyVTydnu = new HashMap<>(Map.of(                  // Založíme si Mapu co reprezentuje dny v týdnu
                0, "Pondělí",                                                           //  (jen tak)
                1, "Úterý",
                2, "Středa",
                3, "Čtvrtek",
                4, "Pátek"
        ));

        String denTestu = "";
        for (int i = 0; i < znamkyZMatematiky.get("Honza").size(); i++) {       // Iterujeme skrz všechny Honzovi známky
            if (znamkyZMatematiky.get("Honza").get(i).equals(4)) {              // a hledáme prvek v listu který se rovná 4
                denTestu = dnyVTydnu.get(i);                                    // Když najdeme index dne, získáme Stringovou hodnotu
            }                                                                   // (z pomocné mapy výše), odpovídající indexu a následně
        }                                                                       // uložíme do proměnné denTestu

        System.out.println(denTestu);                                           // Tiskneme den kdy Honza dostal z testu za 4.

    }
}
