package goit.calculator;

import goit.calculator.parsers.SimpleParser;
import goit.calculator.streams.ConsoleStream;

//https://cacoo.com/diagrams/xLPePzwytLxEAdyt#2F1F8

public class Bootstrap {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new ConsoleStream(), new SimpleParser());
        calculator.run();
    }
}
