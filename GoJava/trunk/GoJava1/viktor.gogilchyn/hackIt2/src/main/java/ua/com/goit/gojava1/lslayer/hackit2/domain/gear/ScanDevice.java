package ua.com.goit.gojava1.lslayer.hackit2.domain.gear;

import ua.com.goit.gojava1.lslayer.hackit2.domain.HackitWrongParameterException;


public class ScanDevice extends AbstractHardware implements Hardware {
    public ScanDevice(String name) throws HackitWrongParameterException {
        super();
        super.setName(name);
        super.addPurpose("scan", 1); // Every simple device can do it's job.
    }
}
