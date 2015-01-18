
public class RegisteredUser extends User {
	
	public String getNickName() {
		return new String("I'm registered user Timur");
	}
	
	@Override
	public String getPassword() {
		return new String("My password is ***********");
	}
}