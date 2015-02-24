package ua.com.goit.gojava1.lslayer.hackit2;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.catalogs.Catalog;
import ua.com.goit.gojava1.lslayer.hackit2.catalogs.CatalogBuilder;
import ua.com.goit.gojava1.lslayer.hackit2.exception.HackitWrongParameterException;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.Hardware;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.devices.BombDevice;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.devices.InfoDevice;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.devices.ScanDevice;

public class CatalogTest {
    private Catalog catalog_abc;
    private Catalog catalog_rug;
    private Catalog catalog_hue;
    private Hardware itemOne;
    private Hardware itemTwo;
    private Hardware itemThree;

    @Before
    public void init() {
        CatalogBuilder builder = new CatalogBuilder();
        catalog_abc = builder.setName("abc").build();
        catalog_hue = builder.setName("hue").setLink(catalog_abc).build();
        catalog_rug = builder.setName("rug").setLink(catalog_abc).setLink(catalog_hue).build();
        try {
            itemOne = new BombDevice("Bomb");
            itemTwo = new ScanDevice("ScanMaster2000");
            itemThree = new InfoDevice("Informator");
        } catch (HackitWrongParameterException e) {
            e.printStackTrace();
        }
        catalog_abc.registerAsClient(itemOne);
        catalog_hue.registerAsClient(itemThree);
        catalog_rug.registerAsClient(itemTwo);
    }

    @Test
    public void testCatalogCreation() {
        System.out.println(catalog_rug.getPathToClient(itemOne));
    }

}
