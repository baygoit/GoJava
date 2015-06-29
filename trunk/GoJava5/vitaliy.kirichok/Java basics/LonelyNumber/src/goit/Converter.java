package goit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Converter {

    public static List<Integer> convert(String numbers) {
        Scanner scanner = new Scanner(numbers);
        List<Integer> result = new ArrayList<Integer>();
        while (scanner.hasNextInt()) {
            result.add(scanner.nextInt());
        }
        return result;
    }
}
