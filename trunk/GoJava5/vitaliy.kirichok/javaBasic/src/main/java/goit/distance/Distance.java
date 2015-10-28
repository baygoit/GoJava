package goit.distance;

import goit.common.Console;
import goit.common.ParseException;

import java.util.Collections;
import java.util.List;

public class Distance {

    public static void main(String[] args) {
        Console console = new Console();
        List<Integer> number;
        do {
            try {
                number = console.readNumbers("Enter numbers:");
                int firstNumber = Collections.min(number);
                int firstPosition = number.indexOf(firstNumber);
                System.out.println("Results([FirstValue, SecondValue] = Distance):");
                findAllPositions(number, firstNumber, firstPosition, findSecond(number, firstPosition));
            } catch (ParseException e) {
                console.writeLine(e.toString());
            }
        } while (console.hasNext());
        console.close();
    }

    private static Integer findSecond(List<Integer> number, int position) {
        Integer result = Integer.MAX_VALUE;
        for (int index = 0; index < number.size(); index++) {
            if (number.get(index) <= result & index != position) {
                result = number.get(index);
            }
        }
        return result;
    }

    private static void findAllPositions(List<Integer> number, Integer firstNumber, int firstPosition, Integer secondNumber) {
        for (int index = 0; index < number.size(); index++) {
            if (number.get(index).equals(secondNumber) && firstPosition != index) {
                System.out.println(String.format("[%s, %s] = %s", firstNumber, number.get(index), Math.abs(firstPosition - index)));
            }
        }
    }
}
