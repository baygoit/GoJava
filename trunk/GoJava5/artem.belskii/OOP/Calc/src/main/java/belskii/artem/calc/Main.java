package belskii.artem.calc;


public class Main {

	public static void main(String[] args) {
		Console console  = new Console();
		String input = console.read();
		Parser parser = new Parser();
		String [] expression=parser.convert(input);
		Calc calc = new Calc();
		System.out.println(calc.calculate(expression));
	}

}
