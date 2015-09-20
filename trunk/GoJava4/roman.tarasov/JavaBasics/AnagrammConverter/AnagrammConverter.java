public class AnagrammConverter {
	int pointToResult = 0;
	char[] result;
	char[] buffer;
	int lenParsed;
	int bufferPoint;
	final int NULL_POINTER = 0;
	
	public static void main(String[] args) {
		String inputString = " test string ";
		System.out.println("string to be converted: "+inputString);
		AnagrammConverter converter = new AnagrammConverter();
		System.out.println("result                : "+converter.doAnagramm(inputString));
	}
	String doAnagramm(String input) {
		String output = "";
	
		final char spaceSymbol = ' ';
		char[] parsedInput = input.toCharArray();
		lenParsed = parsedInput.length;
		result = new char[lenParsed];
		buffer = new char[lenParsed];
		boolean doWordFlag = false;

		pointToResult = NULL_POINTER;
		bufferPoint = NULL_POINTER;

		for (int pointParsed = NULL_POINTER; pointParsed < lenParsed; pointParsed++) {
			char extracted = parsedInput[pointParsed];
			if (extracted != spaceSymbol) {
				if (!doWordFlag) {
					doWordFlag = true;
					bufferPoint = NULL_POINTER;
				}
				buffer[bufferPoint] = extracted;
				bufferPoint++;
				if(bufferPoint==lenParsed){
					reverseWord();
					addBuffToResult();
					break;
				}
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

		for (pointer = NULL_POINTER; pointer < bufferPoint; pointer++) {
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
		for (int pointer = NULL_POINTER; pointer < bufferPoint; pointer++) {
			reversedBuffer[bufferPoint - 1 - pointer] = buffer[pointer];
		}
		buffer=reversedBuffer;
	}
}
