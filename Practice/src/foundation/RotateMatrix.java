package foundation;

import java.util.*;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Expected output :
//        {
//            {7, 4, 1},
//            {8, 5, 2},
//            {9, 6, 3}
//        };

        int[][] newMatrix = rotate(matrix);
        for (int i = 0; i < newMatrix.length; i++) {
            System.out.println(Arrays.toString(newMatrix[i]));
        }
    }

    public static int[][] rotate(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                newMatrix[i][j] = matrix[matrix.length - 1 - j][i];
            }
        }
        return newMatrix;
    }
}
