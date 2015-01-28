package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.gear.ScanDevice;

public class ScanDeviceTest {
    @Test
    public void testCreation() {
        ScanDevice scanner = new ScanDevice("Vizor3000");
        assertEquals("Vizor3000", scanner.getName());
    }
    @Test
    public void testViewOfScanner() {
        ScanDevice scanner = new ScanDevice("Vizor3000");
        String eol = System.getProperty("line.separator");
        assertEquals("Vizor3000", scanner.toString());
        scanner.addParameter("cpu", 100);
        assertEquals("Vizor3000"+ eol +"cpu: 100", scanner.toString());
    }
}
