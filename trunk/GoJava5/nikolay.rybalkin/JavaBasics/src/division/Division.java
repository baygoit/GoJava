package division;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Division {

    public static void main(String[] args) {

        System.out.println("Enter two numbers (for example -  4/2) : ");
        String numbers = "";
        String[] tokens =  consoleScan(numbers).split("/");
        divisions(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
    }

    public static void divisions(int a, int b) {

        int division;
        int module;
        int count = 0;
        StringBuilder buf = new StringBuilder();
        ArrayList<Integer> columnArray = new ArrayList<Integer>();
        boolean hasPeriod = false;

        String ab = String.valueOf(a) + "|" + String.valueOf(b);
        while (true) {
            division = a / b;
            module = a % b;
            if (division == 0) {
                if (buf.length() == 0) {
                    buf.append("0.(");
                }
                if (!buf.toString().contains(".")) {
                    buf.append(".(");
                }
                a *= 10;
            } else {
                count++;
                buf.append(division);
                buf.append(String.format("%" + count + "s", " ") + "-" + (division * b) + "\n");
                buf.append(String.format("%" + count + "s", " ") + "------" + "\n");
                buf.append(String.format("%" + count + "s", " ") + "  " + module * 10 + "\n");
                a = module;

                columnArray.add(module);
                for (int i = 1; i < columnArray.size(); i++) {
                    if (columnArray.size() > 1) {
                        if (columnArray.get(0).equals(columnArray.get(i))) {
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
        System.out.println(String.format("%" + 5 + "s", "") + "|" + buf);
        System.out.println(buf);
    }

    public static String consoleScan(String number){

        Scanner scanner = new Scanner(System.in);

        try {
            scanner.hasNextInt();
            number = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("You entered is not a number!");
        }
        return number;
    }

}
