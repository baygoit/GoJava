package org.kudryavtsev.gojava.hostalitic;

public class Activity {
    private String name;

    public Activity(String activityName) {
	// TODO Create other activity items
	setName(activityName);
	System.out.println("Activity " + this.getName() + " created.");
    }

    public String getName() {
	return name;
    }

    private void setName(String name) {
	this.name = name;
    }
}
