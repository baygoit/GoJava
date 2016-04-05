package ua.goit.roman;

public class RomanDigit {

	private int arabic;
	private String roman;

	public int getArabic() {
		return arabic;
	}

	public String getRoman() {
		return roman;
	}

	public RomanDigit(int arabic, String roman) {
		this.arabic = arabic;
		this.roman = roman;
	}

	public boolean canBeMinused() {
		return String.valueOf(arabic).startsWith("1");
	}

}
