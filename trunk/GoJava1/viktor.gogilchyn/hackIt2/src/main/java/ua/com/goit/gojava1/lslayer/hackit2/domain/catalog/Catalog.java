package ua.com.goit.gojava1.lslayer.hackit2.domain.catalog;

import java.util.Set;

import ua.com.goit.gojava1.lslayer.hackit2.domain.gear.Hardware;

public interface Catalog {
    
    public static final String [] CLIENT_NAMES = 
        {"mercury", "venus", "earth", "mars", "jupiter", "uranus", "pluto", "europa",
         "io", "ceres", "saturn", "neptune", "charon", "eris", "sedna", "callisto", 
         "ganimede", "oberton", "umbriel", "ariel", "miranda", "triton", "nereid"};
    public static final int MAX_NODES_IN_CATALOG = 16;
    public static final int MAX_CLEINTS_IN_CATALOG = 16;
    public static final String DELIMITER = ">";

    public String getName();

    public void setName(String name);

    public Set<Catalog> getNodes();

    public boolean registerAsNode(Catalog node);
    
    public String registerAsClient(Hardware client);
   
    public String getPathToClient(Hardware client); 

    // TODO Make maps and locations.

}