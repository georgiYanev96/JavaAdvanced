package SetsAndMapsAdvanced;
//Write a program that:
//•	Reads 20 numbers for both players, separated with " " (single space)
//•	Every player can hold only unique numbers
//Each Round both players get the top number from their own deck.
//Player with the bigger number get both numbers and add it on the bottom of his own sequence
//Game ends after 50 rounds or if any player lose all of his numbers
//Input
//•	Numbers – Integer
//•	Output must be "First Player Win!", "Second Player Win!" or "Draw!"

import java.util.*;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] first = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] second = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        LinkedHashSet<Integer> firstPlayersDeck = initiliazePlayersDeck(first);
        LinkedHashSet<Integer> secondPLayersDeck = initiliazePlayersDeck(second);

        boolean gameIsDraw = true;

        for (int i = 0; i < 50; i++) {
            int firstNumber = firstPlayersDeck.iterator().next();
            firstPlayersDeck.remove(firstNumber);

            int secondNumber = secondPLayersDeck.iterator().next();
            secondPLayersDeck.remove(secondNumber);

            if (firstNumber > secondNumber) {
                firstPlayersDeck.add(firstNumber);
                firstPlayersDeck.add(secondNumber);
            } else if (firstNumber < secondNumber) {
                secondPLayersDeck.add(firstNumber);
                secondPLayersDeck.add(secondNumber);
            } else {
                firstPlayersDeck.add(firstNumber);
                secondPLayersDeck.add(secondNumber);
            }

            if (secondPLayersDeck.isEmpty()) {
                System.out.println("First player win!");
                gameIsDraw = false;
                break;
            }
            if (firstPlayersDeck.isEmpty()) {
                System.out.println("Second player win!");
                gameIsDraw = false;
                break;
            }
        }


        if (firstPlayersDeck.size() > secondPLayersDeck.size()) {
            System.out.println("First player win!");
        } else if (firstPlayersDeck.size() < secondPLayersDeck.size()) {
            System.out.println("Second player win!");
        } else if (gameIsDraw) {
            System.out.println("Game is draw!");
        }
    }


    private static LinkedHashSet<Integer> initiliazePlayersDeck(int[] first) {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < first.length; i++) {
            if (!data.contains(first[i])) {
                data.add(first[i]);
            }
        }
        Collections.sort(data, Collections.reverseOrder());
        LinkedHashSet<Integer> initiliazedAndOrdered = new LinkedHashSet<>(data);
        return initiliazedAndOrdered;
    }
}
