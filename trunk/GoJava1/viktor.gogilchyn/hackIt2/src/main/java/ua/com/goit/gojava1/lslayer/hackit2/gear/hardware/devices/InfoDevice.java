package ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.devices;

import ua.com.goit.gojava1.lslayer.hackit2.exception.HackitWrongParameterException;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.AbstractHardware;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.Hardware;

public class InfoDevice extends AbstractHardware implements Hardware {

    public InfoDevice(String name) throws HackitWrongParameterException {
        super();
        super.setName(name);
        super.addPurpose("info", 1);
    }

}
