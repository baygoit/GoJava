package org.kudryavtsev.gojava.hostalitic;

public class Fabric {

    public static void createClient(String clientName) {
	Hostalitic.clients.add(new Client(clientName));
    }

}
