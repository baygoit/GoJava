import java.io.PrintStream;
import java.util.Scanner;


public class Anagrams {
	
	private static final String EXIT = "-1";
	
	public static void main(String[] args){
		
		PrintStream out = System.out;
		Scanner in = new Scanner(System.in);
		
		out.println("для завершеня программы введите '" + EXIT + "'");
		
		while(true){
			out.print("Введите фразу:");
			String phrase = in.nextLine();
			
			if (phrase.equalsIgnoreCase(EXIT))
				System.exit(0);
			
			String[] tokens = phrase.split(" ");
			StringBuilder sb = new StringBuilder();
			for(String s : tokens){
				char[] chars = s.toCharArray();
				for(int i = chars.length-1;  i>=0; i--){
					sb.append(chars[i]);
				}
				sb.append(" ");
			}		
			out.println(sb.toString());
		}
	}

}
