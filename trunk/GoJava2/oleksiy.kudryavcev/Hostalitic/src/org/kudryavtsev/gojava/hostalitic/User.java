package org.kudryavtsev.gojava.hostalitic;

public class User {
    private String name;
    
    public User(String userName) {
	//TODO Create other user items
	setName(userName);
	System.out.println("User " + this.getName() + " created.");
    }

    public String getName() {
	return name;
    }

    private void setName(String name) {
	this.name = name;
    }
}
