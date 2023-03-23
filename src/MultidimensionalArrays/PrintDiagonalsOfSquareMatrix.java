package MultidimensionalArrays;

import java.util.Scanner;

//Write a program that reads a matrix from the console. Then print the diagonals.
//The matrix will always be square. On the first line you read a single integer N the matrix size.
//Then on each line N elements. The first diagonal should always start with the element at the first row and col,
//the second diagonal should start with the element at the last row and first col.
public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        int sum = 0;
        int[] firstDiagonal = new int[n];
        int[] secondDiagonal = new int[n];
        for (int row = 0; row < n; row++) {
            String[] inputTokens = scanner.nextLine().split(" ");
            for (int column = 0; column < n; column++) {
                matrix[row][column] = Integer.parseInt(inputTokens[column]);
            }
        }
        for (int row = 0; row < n; row++) {
            firstDiagonal[row] = matrix[row][row];
        }
        int col = 0;
        for (int row = n-1; row >=  0; row--) {
            secondDiagonal[col] = matrix[row][col];
            col++;
        }
        for (int i = 0; i < firstDiagonal.length; i++) {
            System.out.print(firstDiagonal[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < secondDiagonal.length; i++) {
            System.out.print(secondDiagonal[i] + " ");
        }
    }
}

