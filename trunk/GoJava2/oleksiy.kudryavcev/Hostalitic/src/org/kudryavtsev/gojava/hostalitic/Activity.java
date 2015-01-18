package org.kudryavtsev.gojava.hostalitic;

public class Activity {
    private String name;

    public Activity(final String activityName) {
	// TODO Create other activity items
	setName(activityName);
	System.out.println("Activity " + this.getName() + " created.");
    }

    public final String getName() {
	return name;
    }

    private void setName(final String newName) {
	name = newName;
    }
}
