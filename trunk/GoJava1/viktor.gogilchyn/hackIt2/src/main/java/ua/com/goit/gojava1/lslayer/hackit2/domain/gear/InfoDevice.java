package ua.com.goit.gojava1.lslayer.hackit2.domain.gear;

import ua.com.goit.gojava1.lslayer.hackit2.domain.HackitWrongParameterException;


public class InfoDevice extends AbstractHardware implements Hardware {

    public InfoDevice(String name) throws HackitWrongParameterException {
        super();
        super.setName(name);
        super.addPurpose("info", 1);
    }

}
