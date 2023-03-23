package MultidimensionalArrays;
//Write a program that reads two char matrices (A[][] and B[][]) of the same order M * N
//and prints third matrix C[][] which is filled with the intersecting elements of A and B,
//otherwise set the element to '*'. On the first two lines you receive M and N,
//then on 2 * M lines N characters – the matrices elements.
//The matrix elements may be any ASCII char except '*'.

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        Character[][] matrix = new Character[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] inputTokens = scanner.nextLine().split(" ");
            for (int column = 0; column < cols; column++) {
                matrix[row][column] = inputTokens[column].charAt(0);
            }
        }
        Character[][] matrix2 = new Character[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] inputTokens = scanner.nextLine().split(" ");
            for (int column = 0; column < cols; column++) {
                matrix2[row][column] = inputTokens[column].charAt(0);
            }
        }
        Character[][] finalMatrix = new Character[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == matrix2[row][col]) {
                    finalMatrix[row][col] = matrix[row][col];
                } else {
                    finalMatrix[row][col] = '*';
                }
            }
        }
        for (int row = 0; row < finalMatrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(finalMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

