import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Aleksey Kurkov on 11.03.15.
 */

/*    Test cases
1) Input: 2/1024     Output: 0.1953125
2) Input: 42/8       Output: 5.25
3) Input: 12/42      Output: 0.(2857142)
4) Input: 5/3        Output: 1.(6)
*/

public class DivisionCalculator_v2 {

    static int a;
    static int b;
    static int div;
    static int mod;
    static StringBuilder buf = new StringBuilder();
    static StringBuilder stolbikString = new StringBuilder();
    static ArrayList<Integer> stolbikArray = new ArrayList<Integer>();
    static boolean hasPeriod = false;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Input arguments[format A/B]: ");
        String arguments = scanner.nextLine();
        scanner.close();

        String[] argumentsArray;
        argumentsArray = arguments.split("/");

        a = Integer.parseInt(argumentsArray[0]);
        b = Integer.parseInt(argumentsArray[1]);

        int count = 0;
        String ab = String.valueOf(a) + "|" + String.valueOf(b);

        while (true) {
            div = a / b;
            mod = a % b;
            if (div == 0) {
                if (buf.length() == 0) {
                    buf.append("0.(");
                }
                if (buf.toString().contains(".") == false) {
                    buf.append(".(");
                }
                a *= 10;
            } else {
                count++;
                buf.append(div);
                stolbikString.append(String.format("%" + count + "s", " ") + "-" + (div * b) + "\n");
                stolbikString.append(String.format("%" + count + "s", " ") + "-------" + "\n");
                stolbikString.append(String.format("%" + count + "s", " ") + "  " + mod * 10 + "\n");
                a = mod;

                // getting period
                stolbikArray.add(mod);
                for (int i = 1; i < stolbikArray.size(); i++) {
                    if (stolbikArray.size() > 1) {
                        if (stolbikArray.get(0) == stolbikArray.get(i)) {
                            hasPeriod = true;
                        }
                    }
                }
            }

            if (mod == 0 || count == 100 || hasPeriod) {
                break;
            }
        }

        // if result has period - add close-bracket to buf, else - remove brackets
        if (!hasPeriod) {
            buf.deleteCharAt(buf.indexOf("("));
        } else {
            buf.append(")");
        }

        System.out.println(String.format("%" + 3 + "s", " ") + ab);
        System.out.println(String.format("%" + 5 + "s", " ") + "|" + buf);
        System.out.println(stolbikString);
    }
}