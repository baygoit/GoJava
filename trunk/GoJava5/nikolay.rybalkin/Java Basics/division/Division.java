package division;

import java.util.ArrayList;
import java.util.Scanner;

public class Division {

    static int division;
    static int module;
    static StringBuilder buf = new StringBuilder();
    static StringBuilder stolbikString = new StringBuilder();
    static ArrayList<Integer> stolbikArray = new ArrayList<Integer>();
    static boolean hasPeriod = false;

    public static void main(String[] args) {

        System.out.println("Enter two numbers are stripped of their \"/\" : ");
        Scanner scanConsole = new Scanner(System.in);
        String numbers = scanConsole.nextLine();
        String[] tokens = numbers.split("/");
        int num1 = Integer.parseInt(tokens[0]);
        int num2 = Integer.parseInt(tokens[1]);
        int count = 0;
        String ab = String.valueOf(num1) + "|" + String.valueOf(num2);

        while (true) {
            division = num1 / num2;
            module = num1 % num2;
            if (division == 0) {
                if (buf.length() == 0) {
                    buf.append("0.(");
                }
                if (buf.toString().contains(".") == false) {
                    buf.append(".(");
                }
                num1 *= 10;
            } else {
                count++;
                buf.append(division);
                stolbikString.append(String.format("%" + count + "s", " ") + "-" + (division * num2) + "\n");
                stolbikString.append(String.format("%" + count + "s", " ") + "---------" + "\n");
                stolbikString.append(String.format("%" + count + "s", " ") + "  " + module * 10 + "\n");
                num1 = module;

                stolbikArray.add(module);
                for (int i = 1; i < stolbikArray.size(); i++) {
                    if (stolbikArray.size() > 1) {
                        if (stolbikArray.get(0) == stolbikArray.get(i)) {
                            hasPeriod = true;
                        }
                    }
                }
            }

            if (module == 0 || count == 100 || hasPeriod) {
                break;
            }
        }

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
