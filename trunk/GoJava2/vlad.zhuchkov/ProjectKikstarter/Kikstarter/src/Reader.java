import java.util.Scanner;

public class Reader {
	private Scanner sc = new Scanner(System.in);

	public Integer readInt() {
		boolean inputRight = false;
		int temp = 0;
		do {
			try {
				temp = Integer.valueOf(sc.nextLine());
				inputRight = true;
			} catch (NumberFormatException Integer) {
				System.out.println("Illigal input. Only integr required");
				inputRight = false;
			}
		} while (!inputRight);
		return temp;
	}
}
