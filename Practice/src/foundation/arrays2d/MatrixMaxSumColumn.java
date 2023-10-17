package foundation.arrays2d;

import java.util.ArrayList;
import java.util.List;

public class MatrixMaxSumColumn {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

//        int maxSumColumn = findMaxSumColumn(matrix);
        List<Integer> maxSumColumn = findMaxSumColumn(matrix); // should be {3, 6, 9}

        System.out.println("Column with Maximum Sum: " + maxSumColumn); // should be 2
    }

    public static List<Integer> findMaxSumColumn(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        int maxIndex = 0;
        int maxValueCol = 0;

        for (int j = 0; j < matrix[0].length; j++) {
            int currentCol = 0;
            for (int i = 0; i < matrix.length; i++) {
                currentCol += matrix[i][j];
            }
            if (currentCol > maxValueCol) {
                maxIndex = j;
                maxValueCol = currentCol;
            }
        }

        List<Integer> maxColList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            maxColList.add(matrix[i][maxIndex]);
        }

        return maxColList;
    }
}

