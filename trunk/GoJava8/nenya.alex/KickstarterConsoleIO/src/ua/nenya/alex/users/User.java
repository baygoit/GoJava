package ua.nenya.alex.users;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;



public class User implements Externalizable {
	private String login;
	private String password;
	private String email;

	public User(String login, String password, String email) {
		this.login = login;
		this.password = password;
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public User() {
	}


	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		login = (String) in.readObject();
		password = (String) in.readObject();
		email = (String) in.readObject();
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(login);
		out.writeObject(password);
		out.writeObject(email);
	}

}
