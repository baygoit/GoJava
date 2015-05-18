package anagram;

public class Reverse {
	private String input;
	
	public Reverse(String input) {
		this.input = input;
	}

	public String change() {
		String[] arrayString = input.trim().split(" ");
		String result = new String();
		for ( int i = 0; i < arrayString.length; i++ ) {
            String reverse = new StringBuffer(arrayString[i]).reverse().toString();
            result = result + reverse + " ";
        }
		return result.trim();
	}
}
