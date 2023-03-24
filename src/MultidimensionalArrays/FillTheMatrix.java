package MultidimensionalArrays;
import java.util.Scanner;

//Filling a matrix in the regular way (top to bottom and left to right) is boring.
//Write two methods that fill a matrix of size N x N in two different patterns.
//Both patterns are described below:
public class FillTheMatrix {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String[] input = sc.nextLine().split(", ");
            int size = Integer.parseInt(input[0]);
            String pattern = input[1];
            int[][] matrix = new int[size][size];
            switch (pattern) {
                case "A":
                    patternA(matrix);
                    break;
                case "B":
                    patternB(matrix);
                    break;
                default:
                    System.out.println("Incorrect input!");
                    return;
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                 System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

        }

    static void patternA(int[][] matrix) {
            int counter = 1;
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = counter;
                counter++;
            }
        }
    }

    static void patternB(int[][] matrix) {
        int counter = 1;
        for (int i = 0; i < matrix[0].length; i++) {
            int k = i % 2 == 0 ? 0 : matrix.length - 1;
            for (int j = k; j < matrix.length && j >= 0; j = k == 0 ? j + 1 : j - 1) {
                matrix[j][i] = counter;
                counter++;
            }
        }
    }
}
