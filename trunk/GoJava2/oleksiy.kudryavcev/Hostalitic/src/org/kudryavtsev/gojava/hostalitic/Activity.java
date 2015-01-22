package org.kudryavtsev.gojava.hostalitic;

public class Activity {
    private String name;
    private int activityId;
    private String description;

    public Activity(final String activityName) {
	setName(activityName);
	setDescription("Some descrition.");
	System.out.println("Activity " + this.getName() + " created.");
    }

    public final String getName() {
	return name;
    }

    private void setName(final String newName) {
	name = newName;
    }

    public final String getDescription() {
	return description;
    }

    public void setDescription(final String description) {
	this.description = description;
    }
    
    @Override
    public String toString(){
	return getName();
    }
}
