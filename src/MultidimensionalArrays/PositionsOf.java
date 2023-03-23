package MultidimensionalArrays;

import java.util.Scanner;

//Write a program that reads a matrix of integers from the console,
//then a number and prints all the positions at which that number appears in the matrix.
//The matrix definition on the console will contain a line with two positive integer numbers R and
//C – the number of rows and columns in the matrix – followed by R lines, each containing
//C numbers (separated by spaces), representing each row of the matrix.
//The number you will need to find the positions of will be entered on a single line, after the matrix.
//You should print each position on a single line – first print the row, then the column at which the number appears.
//If the number does not appear in the matrix, print not found
public class PositionsOf {
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
        int num = Integer.parseInt(scanner.nextLine());
        boolean thisNumberExists = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == num){
                    System.out.println(row + " " + col);
                    thisNumberExists = true;
                }
            }
        }
        if(!thisNumberExists){
            System.out.println("not found");
        }

    }
}
