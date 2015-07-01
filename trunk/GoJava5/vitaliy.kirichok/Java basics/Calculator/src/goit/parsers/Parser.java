package goit.parsers;

import goit.operations.Operation;

public abstract class Parser {
    public abstract Operation parse(String input) throws ParseException;
}
