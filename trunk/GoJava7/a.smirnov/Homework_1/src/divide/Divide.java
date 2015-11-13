package divide;

public class Divide {
	private static final char SPACE = ' ';
	private static final String UNDER_SCOPE = "_";
	private static final String SEPARATOR = "------";
	private static final String MOVE_TO_NEXT_LINE = "\n";

	public String divide(int firstNumber, int secondNumber) {
		String increasingSpace = " ";		
		StringBuilder resultFromDivide = new StringBuilder();
		StringBuilder result = new StringBuilder();
		
		if (firstNumber % secondNumber == 0) {
			resultFromDivide.
				append(firstNumber / secondNumber);
			saveEveryDividingStep(result, firstNumber, secondNumber, increasingSpace);
		} else {
			if (firstNumber > secondNumber && firstNumber % secondNumber != 0) {
				saveEveryDividingStep(result, firstNumber, secondNumber, increasingSpace);
				resultFromDivide.
					append(firstNumber / secondNumber);
				firstNumber = firstNumber - secondNumber * (firstNumber / secondNumber);
				increasingSpace += SPACE;
			}

			if (resultFromDivide.toString().isEmpty()) {
				resultFromDivide.
					append("0.");
			} else {
				resultFromDivide.
					append(".");
			}

			while (firstNumber % secondNumber != 0 && resultFromDivide.length() < 20) {
				firstNumber = firstNumber * 10;

				if (firstNumber < secondNumber) {
					resultFromDivide.
						append("0");
				} else {
					int resultDivideStep = firstNumber / secondNumber;
					saveEveryDividingStep(result, firstNumber, secondNumber, increasingSpace);
					firstNumber = firstNumber - secondNumber * resultDivideStep;
					resultFromDivide.
						append(resultDivideStep);
					increasingSpace += SPACE;
				}
			}
		}
		result.
			append(increasingSpace).
			append(" result is : ").
			append(resultFromDivide);
		return result.toString();
	}

	private void saveEveryDividingStep(StringBuilder divideStep, 
			int firstNumber, int secondNumber, String increasingSpace) {

		if (firstNumber % secondNumber == 0) {
			divideStep.
				append(increasingSpace).
				append(UNDER_SCOPE).
				append(firstNumber).
				append(MOVE_TO_NEXT_LINE).
				append(increasingSpace).
				append(SPACE).
				append(firstNumber).
				append(MOVE_TO_NEXT_LINE).
				append(increasingSpace).
				append(SEPARATOR).
				append(MOVE_TO_NEXT_LINE);

		} else {
			divideStep.
				append(increasingSpace).
				append(UNDER_SCOPE).
				append(firstNumber).
				append(MOVE_TO_NEXT_LINE).
				append(increasingSpace).
				append(SPACE).
				append(secondNumber * (firstNumber / secondNumber)).
				append(MOVE_TO_NEXT_LINE).
				append(increasingSpace).
				append(SEPARATOR).
				append(MOVE_TO_NEXT_LINE);
		}
	}
}
