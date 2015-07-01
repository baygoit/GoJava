package goit.nz.lesson1.calculator;

public class Calculator {
	private Console console;
	private ExpressionBuilder builder;
	private String input;

	public Calculator() {
		console = new Console();
		builder = new ExpressionBuilder();
		input = "";
	}

	public void run() {
		console.write("Very simple Calc. Ver.1.0");
		do {
			console.write("Operands must be ints, operators only can be + or -, "
					+ "arguments and operator must be separated by whitespaces");
			input = console.read("Input expression:");
			if (builder.parseInput(input)) {
				Computable expression = builder.getExspression();
				console.write(input + " = " + expression.compute());
			} else {
				console.write(builder.getErrorMessage());
			}
		} while (console
				.read("Do you want one more calculation? \"y\" - yes, any other - no :")
				.equals(Console.AGREE_CODE));
		console.write("Calculator is turned off");
	}
}
