package belskii.artem.calc;

public class Calc {

	public int calculate(String[] expression) {
		int answer = Integer.MIN_VALUE;
		Parser parser = new Parser();
		if (parser.validate(expression)) { // change to try catch block
			int operand1 = Integer.parseInt(expression[0]);
			int operand2 = Integer.parseInt(expression[2]);
			if (expression[1].equals("+")) {
				answer = operand1 + operand2;
			}
			if (expression[1].equals("-")) {
				answer = operand1 - operand2;
			}

		} else {
			System.out.println("Validation failed");
		}
		return answer;
	}
}
