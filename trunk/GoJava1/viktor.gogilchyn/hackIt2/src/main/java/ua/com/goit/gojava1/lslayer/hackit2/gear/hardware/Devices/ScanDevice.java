package ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.devices;

import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.AbstractHardware;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.Hardware;

public class ScanDevice extends AbstractHardware implements Hardware {
    public ScanDevice (String name) throws Exception {
        super(name);
        super.addPurpose("scan", 1); //Every simple device can do it's job.
    }
}
