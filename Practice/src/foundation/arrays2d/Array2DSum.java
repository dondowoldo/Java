package foundation.arrays2d;

public class Array2DSum {
    // Write a method that takes a 2D array of integers and returns a new 2D array where
    // the first row consists of the sum of each row of the input array,
    // and the second row consists of the sum of each column of the input array.

    public int[][] sumRowsAndColumns(int[][] matrix) {

        int[][] newArray = new int[2][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            int sumRow = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sumRow += matrix[i][j];
            }
            newArray[0][i] = sumRow;
        }
        for (int i = 0; i < matrix.length; i++) {
            int sumCol = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sumCol += matrix[j][i];
            }
            newArray[1][i] = sumCol;
        }
        return newArray;
    }
}
