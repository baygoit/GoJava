package org.kudryavtsev.gojava.hostalitic;

import java.util.Calendar;

public class Service {
    private String name;
    private int serviceId;
    private String description;
    private Calendar startDate;
    private int term;
    private Activity activity;
    private double cost;

    public Service(final String serviceName) {
	setName(serviceName);
	System.out.println("Service " + this.getName() + " created.");
    }

    public final String getName() {
	return name;
    }

    private void setName(final String newName) {
	name = newName;
    }
}
