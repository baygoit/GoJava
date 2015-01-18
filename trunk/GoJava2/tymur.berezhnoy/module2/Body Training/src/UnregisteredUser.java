import java.util.Scanner;

public class UnregisteredUser extends User implements Registration {
	@Override
	public void registration() {
		System.out.print("Enter your nick name: ");
		setNickName(new Scanner(System.in));
		System.out.print("Enter your password: ");
		setPassword(new Scanner(System.in));
	}
}