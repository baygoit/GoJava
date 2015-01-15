package ua.com.goit.gojava1.iavorskyi;

//import java.util.Scanner;

public class LongDivider {

    public static void main(String[] args) {
    		
    	
    	
    	
    	
    	
    	
    	
/*
        System.out.println("input x/y");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] numbers = input.split("/");
        String result = " ";
        String space = " ";
        String line = "----";
        int div1 = Integer.parseInt(numbers[0]);
        final int div2 = Integer.parseInt(numbers[1]);
        int ten = 10;
        int module;
        int tempResult = 0;
        int part = 0;
        int pow = numbers[0].length();
        int i = 0;
        int j = 0;
        int afterPoint = 10;

        System.out.println(div1 + " / " + div2);

        if (div2 == 0) {
            System.out.println("You can not divide by 0.");
        } else {

            if (div1 < div2) {
                result += "0,";
                div1 *= ten;
                while (div1 < div2) {
                    div1 *= ten;
                    result += "0";
                }
            }

            // finding first number to divide
            do {
                // if (div1 < div2) {
                // break;
                // }
                module = (int) Math.pow(ten, pow - i);
                tempResult = (div1 / module) / div2;
                if (tempResult >= 1) {
                    System.out.println(tempResult * div2);
                    result += tempResult;
                    part = div1 / module - (tempResult * div2);
                    break;
                }
                i++;
            } while (tempResult < 1);

            System.out.println(line);

            // dividing rest
            do {
                if (numbers[0].length() <= i) {
                    break;
                } else {
                    if (part == 0) {
                        result += numbers[0].substring(i);
                        break;
                    }
                    part = part * 10 + Integer.parseInt(String.valueOf(numbers[0].charAt(i)));
                }

                if (part / div2 >= 1) {
                    System.out.println(space + part);
                    tempResult = part / div2;
                    part -= div2 * tempResult;
                    result += tempResult;
                    i++;
                    System.out.println(space + (div2 * tempResult));
                    System.out.println(space + line);
                    space += " ";
                }

                if (i >= numbers[0].length()) {
                    break;
                }

            } while (part / div2 < 1);

            if (result.charAt(2) != ',') {
                result += ",";
            }

            // dividing after floating point
            do {
                if (part / div2 < 1) {
                    part *= 10;
                }
                System.out.println(space + part);
                tempResult = part / div2;
                part -= div2 * tempResult;
                result += tempResult;
                j++;
                System.out.println(space + (div2 * tempResult));
                System.out.println(space + line);
                space += " ";
                if (part == 0) {
                    break;
                }
            } while (j < afterPoint);

            result = result.trim();
            System.out.println();
            System.out.println(result);

        }
        in.close();
        */
    }
}
