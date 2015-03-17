import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
public class Anagram {
	public static void main(String[] args) {
		String toPrint = "";
		Scanner sc = new Scanner(System.in);
		StringBuffer input = new StringBuffer(sc.nextLine());
		int end = 0;
		int i = 0;
		int j = 0;
		do {
			end = input.indexOf(" ", end + 1);
			if(end == -1) {
				end = input.length();
			}
			for (int k = i; k <= (i + end - 1) / 2; k++) {
				char tmp = input.charAt(k);
				input.setCharAt(k, input.charAt(end - 1 - j));
				input.setCharAt(end - 1 - j, tmp);
				j++;
			}
			i = end + 1;
			j = 0;
		}while(end != input.length());
		System.out.println(input.toString());
	}
}
