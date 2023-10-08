package foundation.arrays2d;

public class MatrixOfShorterStrings {
    //In this exercise, you will write a method that takes two 2D matrices of strings as input and
    // returns a new matrix made of the shorter string at every position.
    // If strings has the same length, use string in the first input.

    public String[][] shorterStringsMatrix(String[][] mat1, String[][] mat2) {
        String [][] newStrings = new String[mat1.length][mat1[0].length];

        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[i].length; j++) {
                if (mat2[i][j].length() < mat1[i][j].length()) {
                    newStrings[i][j] = mat2[i][j];
                } else {
                    newStrings[i][j] = mat1[i][j];
                }
            }
        }
        return newStrings;
    }
}
