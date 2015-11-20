package ua.com.goit.gojava7.salivon.state;

public abstract class PaymentState extends State {

    public PaymentState() {
        setCommandExit(false);
        setCommandZero(false);

    }

}
