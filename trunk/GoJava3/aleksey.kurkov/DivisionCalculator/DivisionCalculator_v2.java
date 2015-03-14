import java.util.Scanner;

/**
 * Created by Aleksey Kurkov on 11.03.15.
 */

/*    Test cases
1) Input: 2/1024     Output: 0.1953125
2) Input: 42/8      Output: 5.25
*/

public class DivisionCalculator_v2 {

    static int a;
    static int b;
    static int div;
    static  int mod;
    static StringBuilder buf = new StringBuilder();
    static StringBuilder stolbik = new StringBuilder();

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
                    buf.append("0.");
                }
                if (buf.toString().contains(".") == false) {
                    buf.append(".");
                }
                a *= 10;
            } else {
                count++;
                buf.append(div);
                stolbik.append(String.format("%" + count + "s", " ") + "-" + (div*b) + "\n");
                stolbik.append(String.format("%" + count + "s", " ") + "-------" + "\n");
                stolbik.append(String.format("%" + count + "s", " ") + "  " + mod*10 + "\n");
                a = mod;
            }

            if (mod == 0 || count == 100) {
                break;
            }
        }

        System.out.println(String.format("%" + 3 + "s", " ") + ab);
        System.out.println(String.format("%" + 5 + "s", " ") + "|" + buf);
        System.out.println(stolbik);
    }

    /*public static String setSpaces(int div, int b){
        StringBuilder spaces = new StringBuilder();
        int bTemp = div*b;
        for (; bTemp != 0; bTemp /= 10) {
            spaces.append(" ");
        }
        return spaces.toString();
    }*/
}