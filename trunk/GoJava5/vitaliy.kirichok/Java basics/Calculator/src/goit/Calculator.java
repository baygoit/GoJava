package goit;

import goit.operations.Operation;
import goit.parsers.ParseException;
import goit.parsers.Parser;
import goit.streams.Stream;

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
