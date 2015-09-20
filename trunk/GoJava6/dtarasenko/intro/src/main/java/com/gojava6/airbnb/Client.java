package java.com.gojava6.airbnb;

public class Client extends User implements Observer{

    @Override
    public void update(String loyaltyProgramName) {
        System.out.println(getName() + ", " + loyaltyProgramName + " is available for you!");
    }
}
