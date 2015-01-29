package goit.iavorskyi.tools;

public class Autorizer {
// 123
	public boolean login(String login, String password) {
		if (login.equals("user") && password.equals("pass")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean register(String login, String password,	String repeatPassword) {
		if (!password.equals(repeatPassword) || (password.length() < 3) || (login.length() < 3)) {
			return false;
		}
		return true;
	}
}
