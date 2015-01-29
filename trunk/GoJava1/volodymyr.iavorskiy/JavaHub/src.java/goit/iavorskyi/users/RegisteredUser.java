package goit.iavorskyi.users;

import goit.iavorskyi.tools.Subscribable;

public class RegisteredUser extends User implements Subscribable {

	private boolean registeredUser = true;
	
	public boolean subscribe (String email) {
		
		return true;
	}
	
}
