package foundation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayMaxValueTest {

    @Test
    void maxRows() {
        ArrayMaxValue max = new ArrayMaxValue();
        int[][] matrix = new int[][]{
                {1, 5, 9, 7, -5},
                {5, 2, 10, -6, 5},
                {-3, -10, -2, -5, -3}
        };
        assertArrayEquals(new int[]{9, 10, -2}, max.maxRows(matrix));
    }

    @Test
    void maxRowsExample2() {
        ArrayMaxValue max = new ArrayMaxValue();
        int[][] matrix = new int[][]{
                {1, 5},
                {3, 5},
                {0, 0},
                {7, 9}
        };
        assertArrayEquals(new int[]{5, 5, 0, 9}, max.maxRows(matrix));
    }
}