package ua.lslayer.hackit;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "skill")
public final class Skill {
    private static final String OUTPUT_TEMPLATE = "%1$s - %2$s";
    private String name;
    private int value;
    
    public Skill(String name, int value) {
        this.name = name;
        this.value = value;
    }
    public Skill() {
    	
	}
	@Override
    public String toString() {
        return String.format(OUTPUT_TEMPLATE, this.name, this.value);
    }
	@XmlElement(name = "SkillName")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
    
	
}
