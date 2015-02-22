package ua.com.goit.gojava1.lslayer.hackit2.catalogs;

import java.util.List;

public interface Catalog {

    public static final int MAX_NODES_IN_CATALOG = 16;

    public String getName();

    public void setName(String name);

    public List<Catalog> getNodes();

    public boolean registerAsNode(Catalog node);

    public String getPathToNode(String nodeName);

    // TODO Make maps and locations.

}
