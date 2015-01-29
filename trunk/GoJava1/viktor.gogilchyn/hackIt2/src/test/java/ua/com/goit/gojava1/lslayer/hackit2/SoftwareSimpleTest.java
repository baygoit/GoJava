package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.gear.software.Software;
import ua.com.goit.gojava1.lslayer.hackit2.gear.software.programs.SoftScannerProgramm;

public class SoftwareSimpleTest {
    @Test
    public void testSoftwareCreation() {
        String programName = "Advansed Scanner";
        Software soft = new SoftScannerProgramm(programName);
        assertNotNull(soft);
        assertEquals(programName, soft.getName());
        assertEquals(1, soft.getVersion());
    }

}
