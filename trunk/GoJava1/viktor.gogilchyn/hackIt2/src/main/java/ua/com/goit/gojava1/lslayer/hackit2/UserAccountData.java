package ua.com.goit.gojava1.lslayer.hackit2;

import java.util.LinkedList;
import java.util.List;

import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.gear.Gear;

public class UserAccountData { //Bean
    private String loginName;
    private String password;
    private Actor character;
    private List<Gear> stuff = new LinkedList<Gear>();
    
    public UserAccountData() {}

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Actor getCharacter() {
        return character;
    }

    public void setCharacter(Actor character) throws HackitWrongParameterException {
        if (character == null) throw new HackitWrongParameterException("Where is actor?");
        this.character = character;
    }

    public List<Gear> getStuff() {
        return stuff;
    }

    public void setStuff(List<Gear> stuff) throws HackitWrongParameterException {
        if (stuff == null || stuff.size() < 1) throw new HackitWrongParameterException("List doesn't exist");
        this.stuff.addAll(stuff);
    }
    
    public void addStuff(Gear item) throws HackitWrongParameterException {
        if (item == null) throw new HackitWrongParameterException("Where is item?");
        this.stuff.add(item);
    }
    
    
    
}
