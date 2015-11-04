

import java.util.List;

public final class ConsolePrinter {

	private ConsolePrinter() {
	}

	public static void println(String string) {
		System.out.println(string);
	}
	
	public static void printlnListWithIndexes(List<String> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i + 1 + ": " + list.get(i));
		}		
	}
}