package goit;

import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String exitCode;
        do {
            String input = Console.read("Enter numbers:");
            List<Integer> number = Converter.convert(input);
            int firstNumber = Collections.min(number);
            int firstPosition = number.indexOf(firstNumber);
            System.out.println("Results([FirstValue, SecondValue] = Distance):");
            findAllPositions(number, firstNumber, firstPosition, findSecond(number, firstPosition));
            exitCode = Console.read("Repeat? (" + Console.EXIT_CODE + " - yes, otherwise - exit)");
        } while (exitCode.compareToIgnoreCase(Console.EXIT_CODE) == 0);
    }

    private static Integer findSecond(List<Integer> number, int position) {
        Integer result = Integer.MAX_VALUE;
        for (int index = 0; index < number.size(); index++) {
            if (number.get(index).compareTo(result) <= -1 & index != position) {
                result = number.get(index);
            }
        }
        return result;
    }

    private static void findAllPositions(List<Integer> number, Integer firstNumber, int firstPosition, Integer secondNumber) {
        for (int index = 0; index < number.size(); index++) {
            if (number.get(index).compareTo(secondNumber) == 0 & firstPosition != index) {
                System.out.println("[" + firstNumber + ", " + number.get(index) + "] = " + Math.abs(firstPosition - index));
            }
        }
    }
}
