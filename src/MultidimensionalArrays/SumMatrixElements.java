package MultidimensionalArrays;
//Write a program that reads a matrix from the console and prints:
//•	The count of rows
//•	The count of columns
//•	The sum of all matrix’s elements
//On the first line you will get the dimensions of the matrix in format {rows, columns}.
//On the next lines you will get the elements for each row separated with a coma.

import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstMatrixDimensions = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(firstMatrixDimensions[0]);
        int cols = Integer.parseInt(firstMatrixDimensions[1]);
        int[][] matrix = new int[rows][cols];
        int sum = 0;
        for (int row = 0; row < rows; row++) {
            String[] inputTokens = scanner.nextLine().split(", ");
            for (int column = 0; column < cols; column++) {
                matrix[row][column] = Integer.parseInt(inputTokens[column]);
                sum = sum + matrix[row][column];
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
