import java.io.IOException;
import java.util.Scanner;


public class LongDivision {
	public static final int DIGIT_CAPACITY = 6;
	
	public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter divider: ");
        int first = scanner.nextInt();
        System.out.print("Enter dividend: ");
        int second = scanner.nextInt();
        scanner.close();
        System.out.println("-" + first + " |" + second);
        String space = String.format("%" + 2 + "s", " ");
        int[] interimResult = dividePart(first, second);
        System.out.println(space + interimResult[0] * second + " |" + divide(first, second, false));
        divide(first, second, true);

    }

    public static int[] dividePart(int divider, int dividend) {
        int[] result = new int[2];
        result[0] = (int) divider / dividend;
        result[1] = divider % dividend;
        return result;
    }

    public static double divide(int divider, int dividend, boolean printPermision) {
        double result = 0;
        int[] interimResult;
        int dividerCounter = 0;
        if (dividend == 0) {
            return divider;
        }
        double dividedCoef = 1;
        int numberCounter = 0;
        do {
        	interimResult = dividePart(divider, dividend);
        	showDivideProcess(dividerCounter, divider, dividend, interimResult[0], printPermision);
            if (interimResult[0] == 0) {
            	divider *= 10;
                if (dividerCounter == 0) {
                    dividedCoef *= 10;
                } else {
                    numberCounter++;
                }
            } else {
            	divider = interimResult[1];
                result += (interimResult[0] * (1 / dividedCoef));
                dividedCoef *= 10;
            }
            
            dividerCounter++;
        } while ((interimResult[1] != 0) && (numberCounter < DIGIT_CAPACITY));
        return result;
    }

    public static void showDivideProcess(int iteraionCount, int divider, int dividend, int interimResult, boolean printPermishion) {
        int numberOfSymbols = 2;
        int divRes = (int) divider / 10;
        while (divRes > 10) {
        	numberOfSymbols++;
        	divRes /= 10;
        }
    	if ((interimResult != 0) && (printPermishion == true)) {
    		String spaces = "";
    		if (iteraionCount != 1) {
    			spaces = String.format("%" + (iteraionCount - 2) + "s", " ");
    		}
            System.out.println(" " + spaces + divider);
            System.out.println(spaces + "-" + interimResult * dividend);
            System.out.print(spaces);
            for (int i = 0; i <= numberOfSymbols; i++) {
            	System.out.print("-");
            }
            System.out.println(); 
        }
    }
}
