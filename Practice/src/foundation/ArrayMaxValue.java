package foundation;

import java.util.Arrays;

public class ArrayMaxValue {
    //Write a function int[] maxRows(int[][] matrix) that takes a matrix and finds the maximum
    // number for each row. It returns an array containing the max number from each row.

    //Keep in mind that the matrix doesn't have to be a square matrix, meaning it can have different
    // amount of rows and columns.

    public int[] maxRows(int[][] matrix) {
        int[] maxValues = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int maxInRow = matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] > maxInRow) {
                    maxInRow = matrix[i][j];
                }
            }
            maxValues[i] = maxInRow;
        }
        return maxValues;
    }
}
