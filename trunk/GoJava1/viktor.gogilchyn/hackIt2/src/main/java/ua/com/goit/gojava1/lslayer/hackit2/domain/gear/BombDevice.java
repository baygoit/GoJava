package ua.com.goit.gojava1.lslayer.hackit2.domain.gear;

import ua.com.goit.gojava1.lslayer.hackit2.domain.HackitWrongParameterException;


public class BombDevice extends AbstractHardware implements Hardware {

    public BombDevice(String name) throws HackitWrongParameterException {
        super();
        super.setName(name);
        super.addPurpose("explode", 1);
    }

}
