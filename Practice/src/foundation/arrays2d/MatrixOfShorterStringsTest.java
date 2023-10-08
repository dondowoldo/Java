package foundation.arrays2d;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixOfShorterStringsTest {

    @Test
    void shorterStringsMatrix() {
        MatrixOfShorterStrings matrix = new MatrixOfShorterStrings();

        String[][] first = new String[][]{
                {"apple", "banana", "orange"},
                {"cat", "dog", "elephant"},
                {"red", "green", "blue"}
        };

        String[][] second = new String[][]{
                {"app", "pear", "grape"},
                {"rabbit", "fox", "lion"},
                {"purple", "pink", "yellow"}
        };


        assertArrayEquals(new String[][]{
                {"app", "pear", "grape"},
                {"cat", "dog", "lion"},
                {"red", "pink", "blue"}
        }, matrix.shorterStringsMatrix(first, second));
    }
}