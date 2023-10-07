package foundation.arrays2d;

public class ArrayTranspose {
    //Write a method called transpose(int[][] matrix) which takes a 2D integer array as input and returns its transpose.
    // The transpose of a matrix is a new matrix in which the rows and columns are swapped.
    // That is, the first row of the original matrix becomes the first column of the new matrix,
    // the second row becomes the second column, and so on.


    public int[][] transpose(int[][] matrix) throws IllegalArgumentException {
        int initialRowLength = matrix[0].length;
        for (int j = 0; j < matrix.length; j++) {
            if (matrix[j].length != initialRowLength) {
                throw new IllegalArgumentException();
            }
        }

        int[][] transposed = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposed[i][j] = matrix[j][i];
            }
        }
        return transposed;
    }
}
