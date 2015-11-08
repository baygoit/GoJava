package yalex;

public class MobileMessenger implements Messenger{
	private User user;
	private String message;

	public MobileMessenger(User user, String message) {
		this.user = user;
		this.message = message;
	}
	
	public void send() {
		System.out.println(user.getName() + ": " + getMessage());
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
