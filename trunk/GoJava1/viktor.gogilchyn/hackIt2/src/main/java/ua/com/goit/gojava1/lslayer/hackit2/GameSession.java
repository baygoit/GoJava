package ua.com.goit.gojava1.lslayer.hackit2;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava1.lslayer.hackit2.gear.Gear;

public final class GameSession { //Singleton. There is only one game per app. Multithreading ignored for a while 
    private static GameSession instance = new GameSession(); 
//    private List<Actor> gamers = new ArrayList<Actor>();
    private List<Gear> stuff = new ArrayList<Gear>();
    private GameSession() {
        
    }
    public static GameSession getInstance() {
        return instance;
    }
    public void addStuff(Gear item) {
        this.stuff.add(item);
    }
    
    public String displayStuffList() {
        String eol = System.getProperty("line.separator");
        String result = "Stuff list:";
        for (Gear element : stuff) {
            result += eol + element.getStringForOutput();
        }
        return result;
    }

}
