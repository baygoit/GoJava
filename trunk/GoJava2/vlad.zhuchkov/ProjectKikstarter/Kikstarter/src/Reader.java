import java.util.Scanner;

public class Reader {
	private Scanner sc = new Scanner(System.in);
	public Integer readInt() {
		try {
			return Integer.valueOf(sc.nextLine());
		} catch (NumberFormatException Integer) {
			return(-1);
		}
	}
}
