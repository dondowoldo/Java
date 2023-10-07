package foundation.arrays2d;

import java.util.Arrays;

public class MatrixAddition {
    //Write a matrixAddition function which takes two matrices as parameters and returns a new matrix which
    // is the sum of the two matrices. The method should only add matrices with the same number of rows and columns and
    // throw an exception with"Invalid input" message on invalid input.
    //
    //Write 2 different test cases for the method.

    public int[][] matrixAddition(int[][] mat1, int[][] mat2) throws IllegalArgumentException, NullPointerException {
        if (mat1 == null || mat2 == null) {
            throw new NullPointerException();
        }
        if (mat1.length != mat2.length || mat1[0].length != mat2[0].length) {
            throw new IllegalArgumentException("Invalid Input");
        }

        int[][] newMatrix = new int[mat1.length][mat1[0].length];

        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[i].length; j++) {
                newMatrix[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        return newMatrix;

    }
}


