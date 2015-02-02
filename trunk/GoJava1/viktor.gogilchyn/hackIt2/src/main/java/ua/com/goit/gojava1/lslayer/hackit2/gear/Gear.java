package ua.com.goit.gojava1.lslayer.hackit2.gear;

public interface Gear {
    public String getName();
    //TODO owner. Every thing should be owned by someone.
    public int getPurposeValue(String commandToInvoke);
    public String getStringForOutput();

}
