package ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.devices;

import ua.com.goit.gojava1.lslayer.hackit2.exception.HackitWrongParameterException;
import ua.com.goit.gojava1.lslayer.hackit2.gear.Gear;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.AbstractHardware;

public class InfoDevice extends AbstractHardware implements Gear {

    public InfoDevice(String name) throws HackitWrongParameterException {
        super(name);
        super.addPurpose("info", 1);
    }

}
