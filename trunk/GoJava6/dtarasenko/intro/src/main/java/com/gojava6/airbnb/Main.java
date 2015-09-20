package com.gojava6.airbnb;

import com.gojava6.airbnb.application.Application;
import com.gojava6.airbnb.application.LoyaltyProgram;
import com.gojava6.airbnb.users.Client;
import com.gojava6.airbnb.users.Host;

public class Main {
    public static void main(String[] args) throws Exception{

        Application app = new Application();

        Host host1 = new Host();
        host1.setName("Nikolay");
        host1.setSurName("Chayka");
        host1.setEmail("nikolay.chayka@gmail.com");
        host1.setApartmentType("House");
        host1.setCity("Sofia");

        Client client1 = new Client();
        client1.setName("Roman");
        client1.setSurName("Solomakha");
        client1.setEmail("roman.solomakha@gmail.com");

        Client client2 = new Client();
        client2.setName("Vladislav");
        client2.setSurName("Shurubalko");
        client2.setEmail("vladislav.shurubalko@gmail.com");

        LoyaltyProgram loyaltyProgram = new LoyaltyProgram();
        loyaltyProgram.setLoyaltyProgramName("New Year loyalty program");
        loyaltyProgram.setAvailable(false);

        //Registration of 1 host and 2 clients
        app.registerUser(host1);
        app.registerUser(client1);
        app.registerUser(client2);

        //Two clients signed for loyalty program notification
        loyaltyProgram.registerObserver(client1);
        loyaltyProgram.registerObserver(client2);
        loyaltyProgram.setAvailable(true);

        //1 of 2 clients decided that he or she doesn't want to receive notifications
        loyaltyProgram.removeObserver(client1);
        loyaltyProgram.setAvailable(true);
    }
}
