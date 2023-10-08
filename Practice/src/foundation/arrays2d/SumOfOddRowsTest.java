package foundation.arrays2d;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfOddRowsTest {
    static SumOfOddRows sum;

    @BeforeEach
    void init() {
        sum = new SumOfOddRows();
    }

    @Test
    void sumOddRows() {
        int[][] matrix = new int[][]{
                {1, 2},
                {3, 4},
                {5, 6}
        };

        assertEquals(7, sum.sumOddRows(matrix));
    }

    @Test
    void sumOddRowsBigger() {
        int[][] matrix = new int[][]{
                {4, 5, 2},
                {1, 6, 3},
                {7, 3, 8},
                {9, 0, 1},
                {3, 8, 7}
        };
        assertEquals(20, sum.sumOddRows(matrix));
    }

    @Test
    void throwsException() {
        int[][] matrix = null;
        assertThrows(IllegalArgumentException.class, () -> sum.sumOddRows(matrix));
    }
}