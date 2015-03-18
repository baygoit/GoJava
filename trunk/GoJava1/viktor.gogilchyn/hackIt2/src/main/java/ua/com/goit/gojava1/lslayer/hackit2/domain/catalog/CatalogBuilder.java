package ua.com.goit.gojava1.lslayer.hackit2.domain.catalog;

import ua.com.goit.gojava1.lslayer.hackit2.domain.gear.LocalCatalog;

public class CatalogBuilder {
   
    private Catalog catalog = new LocalCatalog();
    
    public CatalogBuilder setName(String name) {
        this.catalog.setName(name);
        return this;
    }
    
    public CatalogBuilder setLink(Catalog node) {
        return this.catalog.registerAsNode(node) ? this : null;
    }
    
    public Catalog build() {
        Catalog returnValue = this.catalog;
        this.catalog = new LocalCatalog();
        return returnValue;
    }
}
