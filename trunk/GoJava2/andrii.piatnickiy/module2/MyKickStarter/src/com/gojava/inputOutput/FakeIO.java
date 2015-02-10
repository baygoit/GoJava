package com.gojava.inputOutput;

public class FakeIO implements IO {

    @Override
    public void print(String string) {
        System.out.println("Fake!!!");
    }

    @Override
    public int inputInt() {
        return 0;
    }

}
