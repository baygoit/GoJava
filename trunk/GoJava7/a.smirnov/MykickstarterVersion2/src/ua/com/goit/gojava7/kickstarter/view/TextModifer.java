package ua.com.goit.gojava7.kickstarter.view;

public class TextModifer {
	private static final String SEPARATOR = "**********************************************************************";
	private static final String MOVE_TO_THE_NEXT_LINE = "\n";
	private static final String SPACE = " ";
	private static final char QUOTE_START_AND_FINAL_SYMBOL = '"';

	public String modifyQuoteTextBeforePrint(String quoteText, String quoteAuthor) {
		StringBuilder result = new StringBuilder();
		StringBuilder quoteStringModifer = new StringBuilder();

		int lengthOfStringForAuthor = 70 - quoteAuthor.length();
		for (int index = 0; index < lengthOfStringForAuthor; index++) {
			quoteStringModifer.append(SPACE);
		}

		result.
			append(SEPARATOR).
			append(MOVE_TO_THE_NEXT_LINE).
			append(getModifiedString(quoteText)).
			append(QUOTE_START_AND_FINAL_SYMBOL).
			append(MOVE_TO_THE_NEXT_LINE).
			append(quoteStringModifer).
			append(quoteAuthor).
			append(MOVE_TO_THE_NEXT_LINE).
			append(SEPARATOR);

		return result.toString();
	}

	public String getModifiedString(String string) {

		StringBuilder result = new StringBuilder();
		StringBuilder projectStringModifer = new StringBuilder();

		String[] arrayOfQquoteWords = string.split(SPACE);
		int amountOfWords = arrayOfQquoteWords.length;

		for (int index = 0; index < amountOfWords; index++) {
			if (projectStringModifer.length() + arrayOfQquoteWords[index].length() <= 70) {
				if (index == amountOfWords - 1) {
					projectStringModifer.append(arrayOfQquoteWords[index]);

					result.append(projectStringModifer);
					projectStringModifer.delete(0, projectStringModifer.length());
				} else {
					projectStringModifer.append(arrayOfQquoteWords[index]).append(SPACE);
				}
			} else {
				result.append(projectStringModifer).append(MOVE_TO_THE_NEXT_LINE).append(arrayOfQquoteWords[index])
						.append(SPACE);
				projectStringModifer.delete(0, projectStringModifer.length());
			}
		}

		return result.toString();
	}

}
