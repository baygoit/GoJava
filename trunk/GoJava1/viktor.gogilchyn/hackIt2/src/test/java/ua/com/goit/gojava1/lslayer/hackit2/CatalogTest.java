package ua.com.goit.gojava1.lslayer.hackit2;

import org.junit.BeforeClass;

import ua.com.goit.gojava1.lslayer.hackit2.catalogs.Catalog;
import ua.com.goit.gojava1.lslayer.hackit2.catalogs.CatalogBuilder;

public class CatalogTest {
    private Catalog catalog_abc;
    private Catalog catalog_rug;
    private Catalog catalog_hue;
    @BeforeClass
    public void init() {
        CatalogBuilder builder = new CatalogBuilder();
        catalog_abc = builder.setName("abc").build();
        catalog_hue = builder.setName("hue").setLink(catalog_abc).build();
        catalog_rug = builder.setName("rug").setLink(catalog_abc).setLink(catalog_hue).build();
    }

}
