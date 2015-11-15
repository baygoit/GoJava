package ua.com.goit.gojava7.kickstarter.view;

public class TextModifer {
	private static final String SEPARATOR = "**********************************************************************";
	private static final String MOVE_TO_THE_NEXT_LINE = "\n";
	private static final String SPACE = " ";
	private static final char QUOTE_START_AND_FINAL_SYMBOL = '"';
	private static final String SYMBOL_BEFORE_AUTHOR_NAME = "(c)";

	public String getModifiedQuoteBeforePrint(String quoteText, String quoteAuthor) {
		StringBuilder result = new StringBuilder();
		StringBuilder spaces = new StringBuilder();

		int lengthOfStringForAuthor = 70 - (SYMBOL_BEFORE_AUTHOR_NAME.length() + quoteAuthor.length());
		
		for (int index = 0; index < lengthOfStringForAuthor; index++) {
			spaces.
				append(SPACE);
		}

		result.
			append(SEPARATOR).
			append(MOVE_TO_THE_NEXT_LINE).
			append(QUOTE_START_AND_FINAL_SYMBOL).
			append(getModifiedText(quoteText)).
			append(QUOTE_START_AND_FINAL_SYMBOL).
			append(MOVE_TO_THE_NEXT_LINE).
			append(spaces).
			append(SYMBOL_BEFORE_AUTHOR_NAME).
			append(quoteAuthor).
			append(MOVE_TO_THE_NEXT_LINE).
			append(SEPARATOR);

		return result.toString();
	}

	public String getModifiedText(String string) {

		StringBuilder result = new StringBuilder();
		StringBuilder modifedTextLine = new StringBuilder();

		String[] quoteWords = string.split(SPACE);
		int amountOfWords = quoteWords.length;

		for (int index = 0; index < amountOfWords; index++) {
		
			if (modifedTextLine.length() + quoteWords[index].length() <= 70) {
				
				if (index == amountOfWords - 1) {
					modifedTextLine.
						append(quoteWords[index]);

					result.
						append(modifedTextLine);
					
					modifedTextLine.
						delete(0, modifedTextLine.length());
				} else {
					
					modifedTextLine.
						append(quoteWords[index]).
						append(SPACE);
				}
			} else {
				if (index == amountOfWords - 1) {
					
					result.
						append(modifedTextLine).
						append(MOVE_TO_THE_NEXT_LINE).
						append(quoteWords[index]);
				
				} else {
					result.
						append(modifedTextLine).
						append(MOVE_TO_THE_NEXT_LINE);
				
					modifedTextLine.
						delete(0, modifedTextLine.length());
					
					modifedTextLine.
						append(quoteWords[index]).
						append(SPACE);
				}
				
			}
		}
		return result.toString();
	}
}
