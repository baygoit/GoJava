package org.kudryavtsev.gojava.hostalitic;

public class Service {
    private String name;

    public Service(final String serviceName) {
	// TODO Create other activity items
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
