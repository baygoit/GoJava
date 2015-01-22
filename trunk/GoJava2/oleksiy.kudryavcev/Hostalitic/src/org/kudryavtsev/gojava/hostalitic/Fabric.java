package org.kudryavtsev.gojava.hostalitic;

public class Fabric {

    public static void createClient(String clientName) {
	Hostalitic.clients.add(new Client(clientName));
    }
    
    public static void createActivity(String activityName) {
	Hostalitic.activities.add(new Activity(activityName));
    }
    
    public static void createService(String serviceName, Activity activityName) {
	Hostalitic.services.add(new Service(serviceName, activityName));
    }

}
