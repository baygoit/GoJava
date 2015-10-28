import java.util.Scanner;

/**
 * Created by Aleksey Kurkov on 11.03.15.
 */

public class DivisionCalculator_v1 {
    public static void main(String[] args) {
        int a, b, a1 = 0, c, countOfNumbersA, countOfNumbersB, ostatok = 0;
        float result2;
        StringBuffer result = new StringBuffer(10);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Input arguments[format A/B]: ");
        String arguments = scanner.nextLine();
        scanner.close();

        String[] argumentsArray;
        argumentsArray = arguments.split("/");

        a = Integer.parseInt(argumentsArray[0]);
        b = Integer.parseInt(argumentsArray[1]);

        int bTemp = b;

        countOfNumbersB = 0;
        for (; bTemp != 0; bTemp /= 10) {
            ++countOfNumbersB;
        }

        result2 = (float) a / (float) b;

        boolean end = false;
        while (!end) {
            if (a < b) {
                System.out.println(-a + " |" + b);
                a *= 10;
                ostatok = a % b;
                a1 = a - ostatok;
                System.out.println("  " + a1 + "|" + result2);
                System.out.println("  ---");
                a = ostatok * 10;
                System.out.println("  " + a);

                if (a / 10 < b) {
                    a = ifASmallerB(a, b, ostatok, a1, 0);
                }

                if (a / 10 < b) {
                    a = ifASmallerB(a, b, ostatok, a1, 1);
                }

                if (a / 10 < b) {
                    a = ifASmallerB(a, b, ostatok, a1, 2);
                }

                if (a / 10 < b) {
                    a = ifASmallerB(a, b, ostatok, a1, 3);
                }
                ostatok = a % b;
                a1 = a - ostatok;
                System.out.println("     -" + a1);
            }
        }
    }

    public static int ifASmallerB(int a, int b, int ostatok, int a1, int level) {
        StringBuffer space1 = new StringBuffer(" -");
        StringBuffer space2 = new StringBuffer("  ---");
        StringBuffer space3 = new StringBuffer("   ");


        for (int i = 0; i < level; i++) {
            space1.insert(0, " ");
            space2.insert(0, " ");
            space3.insert(0, " ");
        }

        ostatok = a % b;
        a1 = a - ostatok;
        System.out.println(space1.toString() + a1);
        System.out.println(space2);
        a = ostatok * 10;
        System.out.println(space3.toString() + a);
        return a;
    }
}