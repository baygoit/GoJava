package org.kudryavtsev.gojava.hostalitic;

public class Service {
    private String name;

    public Service(String serviceName) {
	// TODO Create other activity items
	setName(serviceName);
	System.out.println("Service " + this.getName() + " created.");
    }

    public String getName() {
	return name;
    }

    private void setName(String name) {
	this.name = name;
    }
}
