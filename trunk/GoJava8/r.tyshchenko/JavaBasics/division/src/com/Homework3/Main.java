package com.Homework3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int residueOfDivision;
        String s = " ";
        Scanner sc = new Scanner(System.in);
        System.out.println("input  number");
        double devisionNumber = sc.nextInt();
        System.out.println("input divider number");
        double devider = sc.nextInt();
        residueOfDivision = Model.firstLine(devisionNumber, devider);
        s = Model.deliveryVisualization(residueOfDivision, s, devider);
        System.out.println(s + "0");
    }
}
