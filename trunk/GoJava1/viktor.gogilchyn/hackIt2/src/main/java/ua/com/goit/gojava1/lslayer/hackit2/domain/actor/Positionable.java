package ua.com.goit.gojava1.lslayer.hackit2.domain.actor;


public interface Positionable {
    
    Position getPosition();
    void setPosition(Position where);
    void moveTo(Position position);

}
