package mypackage;

public class WebPlayer {
	protected void player(String s) {
		System.out.println("Do you wanna play one of found audio tracks now?");
		System.out.println("Enter Y to play or N to stop the program.");
		Scanner scanner = new Scanner(System.in);
		String yesOrNo = scanner.nextLine();
		if (yesOrNo.equals("Y") | yesOrNo.equals("y")) {
			System.out.println("Playing " + s + " " + "\u25B6" + " " + "\u266B" + " " + "\u266A");
		}
	}
}
