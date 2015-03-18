package ua.com.goit.gojava1.lslayer.hackit2.domain;

import ua.com.goit.gojava1.lslayer.hackit2.domain.actor.Position;

public class Place {
    private Position position;
    private String name;
    
    public Position getPosition() {
        return position;
    }
    
    public void setPosition(Position position) {
        this.position = position;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
