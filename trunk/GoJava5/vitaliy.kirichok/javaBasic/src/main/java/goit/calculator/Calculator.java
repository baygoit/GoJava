package goit.calculator;

import goit.calculator.operations.Operation;
import goit.calculator.parsers.Parser;
import goit.calculator.streams.Stream;
import goit.common.ParseException;

public class Calculator {
    private Stream stream;
    private Parser parser;

    public Calculator(Stream stream, Parser parser) {
        this.stream = stream;
        this.parser = parser;
    }

    public void run() {
        String input;
        do {
            input = stream.getNext();
            try {
                Operation operation = parser.parse(input);
                stream.showResult(operation.compute().toString());
            } catch (ParseException e) {
                stream.showError(e.toString());
            } catch (ArithmeticException e) {
                stream.showError("Arithmetical error is detected.");
            }
        } while (stream.hasNext());

    }
}
