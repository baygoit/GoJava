import java.util.Scanner;

public class User {
	private int id; // TODO
	private String nickName;
	private String password;
	
	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(Scanner nickName) {
		this.nickName = nickName.nextLine();
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(Scanner password) {
		this.password = password.nextLine();
	}
}