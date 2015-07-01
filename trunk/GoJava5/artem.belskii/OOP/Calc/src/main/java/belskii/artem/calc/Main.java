package belskii.artem.calc;


public class Main {

	public static void main(String[] args) {
		Input console  = new Input();
		console.setMethod("console");
		String input = console.read();
		
		Parser parser = new Parser();
		String [] expression=parser.convert(input);
		Calc calc = new Calc();
		System.out.println(calc.calculate(expression));
	}

}
