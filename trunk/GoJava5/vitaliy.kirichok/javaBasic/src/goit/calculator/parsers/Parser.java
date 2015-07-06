package goit.calculator.parsers;

import goit.calculator.operations.Operation;
import goit.common.ParseException;

public interface Parser {

    Operation parse(String input) throws ParseException;
}
