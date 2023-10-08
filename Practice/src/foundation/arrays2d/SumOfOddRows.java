package foundation.arrays2d;

public class SumOfOddRows {
    //Write a sumOddRows method that takes a 2D array / matrix containing integers and returns the sum 
    // of all elements in odd rows (0-indexed). If the given 2D array / matrix is null, 
    // the function should throw an IllegalArgumentException.


    public int sumOddRows(int[][] matrix) throws IllegalArgumentException {
        if (matrix == null) {
            throw new IllegalArgumentException();
        }

        int sum = 0;
        for (int i = 1; i < matrix.length; i+=2) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}
