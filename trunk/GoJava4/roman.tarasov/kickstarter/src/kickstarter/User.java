package kickstarter;

public class User {
	String[] user;

	User(Repository repository) {
		this.user = repository.users;
	}
}
