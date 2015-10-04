package com.gojava6.homework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PascalTriangle {

    private int level;
    private int[][] triangle;

    public PascalTriangle(int level) {
        this.level = level;
    }

    public static int enterNumber() {

        boolean isDigit = true;
        int result = 0;

        while (isDigit) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("Please, enter number:");

                result = scanner.nextInt();
                isDigit = false;
            } catch (InputMismatchException e) {
                System.out.println("Please, enter correct value!");
            }
        }
        return result;
    }

    public void createArrayLength() {

        triangle = new int[level][];
        int number = 1;

        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new int[number];
            number++;
        }
    }

    public int[][] calculateTriangle() {

       createArrayLength();

        for (int i = 0; i < triangle.length; i++) {
            int number = 1;
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] = number;
                number = number * (i - j) / (j + 1);
            }
        }
        return triangle;
    }

    public void printTriangle() {

        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        PascalTriangle triangle = new PascalTriangle(enterNumber());

        triangle.calculateTriangle();

        triangle.printTriangle();
    }

}
