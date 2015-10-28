package goit.nz.lesson1;

public class Parser {
	private final String DEFAULT_DELIMETER = " ";
	private String delimeter;
	private String errorInputMessage;
	public boolean isParsingSuccessful;

	public Parser() {
		errorInputMessage = "Wrong input!";
		delimeter = DEFAULT_DELIMETER;
		isParsingSuccessful = false;
	}

	public Parser(String errorMessage) {
		errorInputMessage = errorMessage;
		delimeter = DEFAULT_DELIMETER;
		isParsingSuccessful = false;
	}

	public Parser(String delimeter, String errorMessage) {
		errorInputMessage = errorMessage;
		this.delimeter = delimeter;
		isParsingSuccessful = false;
	}

	public int[] stringToInt(String toParse) {
		isParsingSuccessful = false;
		String[] rawData = toParse.split(delimeter);
		int[] result = new int[rawData.length];
		for (int i = 0; i < rawData.length; i++) {
			try {
				result[i] = Integer.parseInt(rawData[i]);
			} catch (NumberFormatException e) {
				System.out.println(errorInputMessage);
				System.out.println(e);
				/*
				 * It's strange but i need to wait a bit because of error
				 * messages were displayed before prompt of next input try
				 */
				/*
				 * try { Thread.sleep(10); } catch (InterruptedException e1) {
				 * e1.printStackTrace(); }
				 */
				return result;
			}
		}
		isParsingSuccessful = true;
		return result;
	}

	public int getFirstIntFromString(String toParse) {
		return stringToInt(toParse)[0];
	}

	public String[] stringToWords(String toParse) {
		isParsingSuccessful = false;
		if (toParse.isEmpty()) {
			return null;
		}
		String[] result = toParse.split(delimeter);
		isParsingSuccessful = true;
		return result;
	}
}
