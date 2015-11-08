package ua.com.goit.gojava1.lslayer.hackit2.domain.catalog;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ua.com.goit.gojava1.lslayer.hackit2.domain.gear.Hardware;

public abstract class AbstractCatalog implements Catalog {


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Catalog [numberOfRegisteredClients=").append(numberOfRegisteredClients).append(", name=").append(name).append(", nodes=")
               .append(nodes).append(", clients=").append(clients).append("]");
        return builder.toString();
    }

    private int numberOfRegisteredClients;
    private String name;
    private Set<Catalog> nodes = new HashSet<Catalog>();
    private Map<String, Hardware> clients = new HashMap<String, Hardware>();

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Set<Catalog> getNodes() {
        return this.nodes;
    }

    @Override
    public boolean registerAsNode(Catalog node) {
        return this.nodes.add(node);
    }

    @Override
    public String registerAsClient(Hardware client) {
        if (this.numberOfRegisteredClients > Catalog.MAX_CLEINTS_IN_CATALOG) {
            return null;
        }
        String nameForClient = generateKeyforClient(client);
        this.clients.put(nameForClient, client);
        this.numberOfRegisteredClients += 1;
        return nameForClient;
        
    }

    private String generateKeyforClient(Hardware client) {
        return CLIENT_NAMES[this.numberOfRegisteredClients];
    }

    @Override
    public String getPathToClient(Hardware client) {
        String returnValue = this.getName() + DELIMITER;
        if (this.clients.containsValue(client)) {
            for (Map.Entry<String, Hardware> entry : this.clients.entrySet()) {
                if (entry.getValue().equals(client)) 
                    return returnValue + entry.getKey();
            }
        } else {
            for (Catalog node : this.getNodes()) {
                if (node.getPathToClient(client) != null) {
                    return returnValue + node.getPathToClient(client);
                }
            }
        }
        return null;
    }

   
}
