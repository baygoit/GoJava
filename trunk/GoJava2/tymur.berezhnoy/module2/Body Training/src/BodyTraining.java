
public class BodyTraining {

	public static void main(String[] args) {
		User user = new User();
		user.createAccount("Supe Duper User", "123456789");
		System.out.println("Login name is: " + user.getNickName());
		System.out.println("Password is: " + user.getPassword());
	}
}
