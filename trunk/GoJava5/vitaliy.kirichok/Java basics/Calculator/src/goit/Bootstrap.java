package goit;

import goit.parsers.SimpleParser;
import goit.streams.Console;

/*
https://cacoo.com/diagrams/M65qLLe5vvIm7wWY#53A71
*/
public class Bootstrap {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new Console(), new SimpleParser());
        calculator.run();
    }
}
