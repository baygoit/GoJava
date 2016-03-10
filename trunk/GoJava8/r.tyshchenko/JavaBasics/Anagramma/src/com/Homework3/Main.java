package com.Homework3;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input words through the gap");
        String a = sc.nextLine();
        Anagrama.getAnagramArray(a);

    }
}

