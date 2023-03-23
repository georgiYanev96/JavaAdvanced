package MultidimensionalArrays;
//Write a program that reads two integer matrices (2D arrays) from the console and compares them element by element.
//For better code reusability, you could do the comparison in a method, which returns true if they are equal and false if not.
//Each matrix definition on the console will contain a line with a positive integer number
//R – the number of rows in the matrix and C – the number of columns – followed by R lines containing the
//C numbers, separated by spaces (each line will have an equal amount of numbers.
//The matrices will have at most 10 rows and at most 10 columns.
//Print equal if the matrices match, and not equal if they don’t match.

import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstMatrixDimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(firstMatrixDimensions[0]);
        int cols = Integer.parseInt(firstMatrixDimensions[1]);
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] inputTokens = scanner.nextLine().split(" ");
            for (int column = 0; column < cols; column++) {
                matrix[row][column] =
                        Integer.parseInt(inputTokens[column]);
            }
        }
        String[] secondMatrixDimensions = scanner.nextLine().split(" ");
        int rows2 = Integer.parseInt(secondMatrixDimensions[0]);
        int cols2 = Integer.parseInt(secondMatrixDimensions[1]);
        int[][] matrix2 = new int[rows2][cols2];
        for (int row = 0; row < rows2; row++) {
            String[] inputTokens = scanner.nextLine().split(" ");
            for (int column = 0; column < cols2; column++) {
                matrix2[row][column] =
                        Integer.parseInt(inputTokens[column]);
            }
        }
        boolean equal = compareTheseTwoMatrixes(matrix, matrix2);
        if(equal){
            System.out.println("equal");
        }else{
            System.out.println("not equal");
        }

    }

    private static boolean compareTheseTwoMatrixes(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length) {
                return false;
            }
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    return false;
                }
            }
        }
        return true;

    }

}

