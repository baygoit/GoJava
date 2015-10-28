import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Anagram {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String source=sc.nextLine();
	int start = -1;
	int end = 0;
	do {
	    end = source.indexOf(" ", end + 1);
	    if (end == -1) {
		end = source.length();
	    }
	    for (int i = end - 1; i >= start + 1; i--) {
		System.out.print(source.charAt(i));
	    }
	    if (end != source.length()) {
		System.out.print(" ");
	    }
	    start = end;
	} while (end != source.length());
    }
}
