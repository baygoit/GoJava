package com.gojava.inputOutput;

import java.util.Scanner;

public class ConsoleIO implements IO {

    @Override
    public void print(String string) {
        System.out.println(string);
    }

    @Override
    public int inputInt() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
}
