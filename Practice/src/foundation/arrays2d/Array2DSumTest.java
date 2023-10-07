package foundation.arrays2d;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Array2DSumTest {

    @Test
    void sumArray() {
        Array2DSum sum = new Array2DSum();
        int[][] matrix = new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        assertArrayEquals(new int[][] {
                {6,15,24},
                {12,15,18}
        }, sum.sumRowsAndColumns(matrix));
    }

    @Test
    void sumArrayOneElement() {
        Array2DSum sum = new Array2DSum();
        int[][] matrix = new int[][] {
                {5}
        };
        assertArrayEquals(new int[][] {
                {5},
                {5}
        }, sum.sumRowsAndColumns(matrix));
    }
}