package com.Homework3;

/**
 * Created by roman on 02.03.16.
 */
public class Model {
    public static int firstLine(double devisionNumber, double devider) {
        int residueOfDivision;
        System.out.println("-" + (int) devisionNumber + " |" + (int) devider);
        residueOfDivision = (int) ((devisionNumber * 10) % devider);

        System.out.println(" " + residueOfDivision + "|" + (devisionNumber / devider));
        System.out.println("----");
        return residueOfDivision;
    }

    public static String deliveryVisualization(int c, String s, double devider) {
        for (; (((c * 10) % devider)) != 0; s += s) {
            System.out.println(s + c * 10);
            System.out.println(s + ((c * 10) - (int) ((c * 10) % devider)));
            System.out.println(s + "----");
            c = (int) ((c * 10) - ((c * 10) - (c * 10) % devider));

        }
        return s;
    }
}
