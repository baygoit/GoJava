import java.util.ArrayList;

/**
 * Created by roznalex on 14.03.2015.
 */
public class    DivideNumbers {
    private static StringBuilder resultBuilder = new StringBuilder();
    private static ArrayList<Integer> dividends = new ArrayList<Integer>();
    private static ArrayList<Integer> dividers = new ArrayList<Integer>();
    private static int count = 0;
    private static int temp;

    public static void main(String[] args) {
        try {
            divide(12, 4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        showProcess();
    }

    static void divide(int a, int b) throws Exception {
        boolean afterPoint = false;

        if (b == 0) {
            throw new Exception("Dividing by zero");
        }
        while (count < 10) {
            if (a % b == 0) {
                divideEntirely(a, b);
                break;
            }
            if (a / b == 0 && afterPoint == false) {
                resultBuilder.append(0 + ",");
                count++;
                afterPoint = true;
                dividends.add(a);
                dividers.add(b);
                a *= 10;
                dividends.add(a);

            }
            if (a / b != 0 || afterPoint == true) {
                temp = a / b;
                resultBuilder.append(temp);
                count++;
                a = (a - b * temp) * 10;
                dividends.add(a);
                dividers.add(b * temp);
            }
        }
    }

    static void divideEntirely(int a, int b) throws Exception { //not finished
        int digit = 0;
        char[] chars;
        dividends.add(a);
        dividers.add(b);

        chars = Integer.toString(a).toCharArray();
        digit = Character.getNumericValue(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (digit > b) {
                temp = digit / b;
                resultBuilder.append(temp);
            }
            digit = (digit - b * temp) * 10 + Character.getNumericValue(chars[i]);
            dividends.add(digit);
            dividers.add(b * temp);
        }
    }

    static void showProcess() {
        int a = dividends.get(0);
        int b = dividers.get(0);
        String spaces = "  ";
        System.out.println("_" + spaces + a + "|" + b);
        System.out.println(spaces + " " + dividers.get(1) + "|" + resultBuilder.toString());
        System.out.println(spaces + "-------");
        for (int i = 2; i < dividends.size() - 1; i++) {
            a = dividends.get(i);
            b = dividers.get(i);
            System.out.println(spaces + "_" + a);
            System.out.println(spaces + " " + b);
            System.out.println(spaces + "-------");
            spaces += " ";
        }
        System.out.println(spaces + "0");
    }

}
