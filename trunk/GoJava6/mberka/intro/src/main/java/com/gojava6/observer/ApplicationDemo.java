package com.gojava6.observer;

public class ApplicationDemo {
    public static void main(String[] args) {

        Host host1 = new Host();
        host1.setCity("Berlin");
        host1.setCity("Rome");
        host1.setCity("Paris");
        host1.setCity("Madrid");
        System.out.println(host1.getListOfCities());
        System.out.println(host1.getCity());

        Client client1 = new Client();
        client1.setUserName("Dexter");
        client1.setUserSurname("Morgan");
        System.out.println(client1);

        Client client2 = new Client();
        client2.setUserName("Deborah");
        client2.setUserSurname("Morgan");
        System.out.println(client2);

        /*Airbnb testAirbnb = new Airbnb();
        testAirbnb.registerObserver(client1);
        testAirbnb.registerObserver(client2);
        System.out.println("Observers list= " + testAirbnb.getListOfObservers());
        testAirbnb.notifyAllObservers();

        testAirbnb.removeObserver(client2);
        testAirbnb.notifyAllObservers();*/



    }
}
