package foundation.arrays2d;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixAdditionTest {


    @Test
    void matrixAddition() {
        MatrixAddition matrix = new MatrixAddition();
        int[][] mat1 = new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int[][] mat2 = new int[][] {
                {9,8,7},
                {6,5,4},
                {3,2,1}
        };

        assertArrayEquals(new int[][]{{10,10,10},{10,10,10},{10,10,10}}, matrix.matrixAddition(mat1,mat2));
    }

    @Test
    void differentSizeColumn() {
        MatrixAddition matrix = new MatrixAddition();
        int[][] mat1 = new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int[][] mat2 = new int[][] {
                {9,8,7,4},
                {6,5,4,5},
                {3,2,1,6}
        };
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> matrix.matrixAddition(mat1, mat2));
        assertTrue(e.getMessage().equals("Invalid Input"));
    }

    @Test
    void differentSizeRow() {
        MatrixAddition matrix = new MatrixAddition();
        int[][] mat1 = new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int[][] mat2 = new int[][] {
                {9,8,7},
                {6,5,4},
                {3,2,1},
                {1,2,3}
        };
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> matrix.matrixAddition(mat1, mat2));
        assertTrue(e.getMessage().equals("Invalid Input"));
    }
}