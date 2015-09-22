package com.airbnb;

/**
 * Created by Игорь on 21.09.2015.
 */
public class Main {
    public static void main(String[] args) {
        try {
            User client1 = new Client("Vasil", "Boyko", "jhg@gmail.com");
            User client2 = new Host("Petro", "Limar", "juy@gmail.com", "Kiev", Host.ApartmentType.Place);

            App airbnb = new App();
            airbnb.register(client1);
            airbnb.register(client2);

            NewsSubscribe newsSubscribe = new NewsSubscribe();
            newsSubscribe.registerObserver(client1);
            newsSubscribe.registerObserver(client1);

            newsSubscribe.notifyObservers();

            newsSubscribe.removeObserver(client1);
            newsSubscribe.notifyObservers();

        } catch (Exception e) {
            System.out.println("Uncorrect data");
        }

    }

}
