package org.kudryavtsev.gojava.hostalitic;

public class User {
    private String name;
    
    public User(final String userName) {
	//TODO Create other user items
	setName(userName);
	System.out.println("User " + this.getName() + " created.");
    }

    public final String getName() {
	return name;
    }

    private void setName(final String newName) {
	name = newName;
    }
}
