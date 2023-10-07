package foundation.arrays2d;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTransposeTest {

    @Test
    void transpose() {
        ArrayTranspose trans = new ArrayTranspose();
        int[][] matrix = new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        assertArrayEquals(new int[][] {
                {1,4,7},
                {2,5,8},
                {3,6,9}
        }, trans.transpose(matrix));
    }

    @Test
    void irregularMatrix() {
        ArrayTranspose trans = new ArrayTranspose();
        int[][] matrix = new int[][] {
                {1,2,3},
                {4,5,6,7},
                {7,8,9}
        };
        assertThrows(IllegalArgumentException.class, () -> trans.transpose(matrix));
    }
}