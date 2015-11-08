package ua.com.goit.gojava.andriidnikitin;

import java.util.Scanner;

public class AnagramBuilder {
	static final String GREETING_MSG = "Hello!"; 
	 
	static final String PROPOSAL_MSG  = "Type your sentence:";
	
	static final String FARAWELL_MSG  = "Have a nice day!"; 
	
	static final String ERR_STREAM_NOT_FOUND_MSG  = 
			"Stream not found! Cannot launch."; 
	
	public static void main(String[] args) throws Exception{
		System.out.println(GREETING_MSG);
			try (Scanner scanner = new Scanner(System.in)){
				System.out.println(PROPOSAL_MSG);				
				String inputRow = new String(); 				
				inputRow = scanner.nextLine();				
				String outputRow = new String();
				outputRow = makeAnagram(inputRow);
				System.out.println("Original row:");
				System.out.println(inputRow);
				System.out.println("Modified row:");
				System.out.println(outputRow);
				System.out.println(FARAWELL_MSG);
				}
			catch (Exception e){
					throw new Exception(ERR_STREAM_NOT_FOUND_MSG);
			}	
	}
	
	public static final String makeAnagram(final String source) {
		 if (source == null || source.isEmpty()) {
			  return source;
		  }	 
		  final StringBuilder buffer = new StringBuilder();
		  int position = 0;
		  do {
			  int positionAlpha = getPosition(source, position, Boolean.TRUE);
			  if (positionAlpha == -1) {
				  break;
			  }
			  append(buffer, source, position, positionAlpha, Boolean.TRUE);		   
			  int positionNotAlpha = getPosition(source, positionAlpha, Boolean.FALSE);
			  append(buffer, source, positionAlpha, positionNotAlpha, Boolean.FALSE);
			  position = positionNotAlpha;
		  } while (position < source.length());
		  return buffer.toString();
		 }
		 
		private static void append(StringBuilder buffer, String source, 
				 int fromPosition, int toPosition, boolean anagrammed) {
			if (fromPosition == toPosition) {
				return;
			}
			if (anagrammed){
				for (int i = fromPosition; i < toPosition; i++) {
					buffer.append(source.charAt(i));
				}
			}
			else {
				for (int i = toPosition-1; i >= fromPosition; i--) {
					buffer.append(source.charAt(i));
				}
			}
		}
		private static int getPosition(String source, 
				int startPosition, boolean isAlphabetic) {
			for (int i = (startPosition == -1 ? 0 : startPosition); 
				i < source.length(); i++) {
				if (Character.isAlphabetic(source.charAt(i)) ^ !isAlphabetic ) {
						return i;
				}
			}
			return source.length();
		}
}