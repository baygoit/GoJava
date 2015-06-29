package goit.nz.lesson1;

public class Parser {
	private final String DEFAULT_DELIMETER = " ";
	private String delimeter;
	private String errorInputMessage;
	public boolean successParsing;
	
	public Parser() {
		errorInputMessage = "Wrong input!";
		delimeter = this.DEFAULT_DELIMETER;
		successParsing = false;
	}
	
	public Parser(String errorMessage) {
		errorInputMessage = errorMessage;
		delimeter = this.DEFAULT_DELIMETER;
		successParsing = false;
	}
	
	public Parser(String delimeter, String errorMessage) {
		errorInputMessage = errorMessage;
		this.delimeter = delimeter;
		successParsing = false;
	}
	
	public int[] stringToInt(String toParse) {
		this.successParsing = false;
		String[] rawData = toParse.split(delimeter);
		int[] result = new int[rawData.length];
		for (int i = 0; i < rawData.length; i++) {
			try {
				result[i] = Integer.parseInt(rawData[i]);
			} catch (NumberFormatException e) {
				System.err.println(this.errorInputMessage);
				System.err.println(e);
				/* It's strange but i need to wait a bit because of error
				  messages were displayed before then prompt of next input try */
				try {
					Thread.sleep(10);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				return result;
			}
		}
		this.successParsing = true;
		return result;
	}
	
	public int getFirstIntFromString(String toParse) {
		return this.stringToInt(toParse)[0];
	}
}
