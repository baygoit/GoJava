public class AnagrammConverter {
	int pointToResult = 0;
	char[] result;
	char[] buffer;
	int lenParsed;
	int bufferPoint;

	public static void main(String[] args) {
		String inputString = " мама мыла раму ";

		AnagrammConverter converter = new AnagrammConverter();
		System.out.println(converter.doAnagramm(inputString));

	}

	String doAnagramm(String input) {
		String output = "";
		final int NULL_POINTER = 0;
		final char spaceSymbol = ' ';
		char[] parsedInput = input.toCharArray();
		lenParsed = parsedInput.length;

		result = new char[lenParsed];
		buffer = new char[lenParsed];

		boolean doWordFlag = false;

		pointToResult = 0;
		bufferPoint = NULL_POINTER;
		System.out.println(new String(parsedInput));
		for (int pointParsed = NULL_POINTER; pointParsed < lenParsed; pointParsed++) {

			char extracted = parsedInput[pointParsed];

			if (extracted != spaceSymbol) {

				if (!doWordFlag) {
					doWordFlag = true;
					bufferPoint = NULL_POINTER;
				}
				buffer[bufferPoint] = extracted;
				bufferPoint++;
				continue;
			}

			if (doWordFlag) {
				doWordFlag = false;
				reverseWord();
				addBuffToResult();
				bufferPoint = NULL_POINTER;

			}
			addCharToResult(' ');

		}

		output = new String(result);
		return output;
	}

	void addBuffToResult() {
		int pointer;

		for (pointer = 0; pointer < bufferPoint; pointer++) {
			result[pointer + pointToResult] = buffer[pointer];
		}
		pointToResult += pointer;
	}

	void addCharToResult(char charToAdd) {
		result[pointToResult] = charToAdd;
		pointToResult++;
	}

	void reverseWord() {
		char[] reversedBuffer = new char[lenParsed];
		for (int index = 0; index < bufferPoint; index++) {
			reversedBuffer[bufferPoint - 1 - index] = buffer[index];
		}
		buffer = reversedBuffer;

	}
}
