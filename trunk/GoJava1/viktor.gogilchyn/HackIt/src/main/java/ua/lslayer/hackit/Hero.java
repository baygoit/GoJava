package ua.lslayer.hackit;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "hero")
@XmlType(propOrder = { "name", "skills" })
public class Hero {
	@XmlElementWrapper (name = "skills")
    private List<Skill> skills;
	private String name;
    

	public Hero() {
	    this.skills = new ArrayList<Skill>();
	}

	public Hero(String name) {
        this.name = name;
        this.skills = new ArrayList<Skill>();
    }
    
    public String listSkills() {
        String eol = System.getProperty("line.separator");  
        String returnValue = new String();
        for (Skill element : this.skills) {
            returnValue += element;
            returnValue += eol;
        }
        return returnValue;
    }
    
    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }
    
    public void removeSkill(Skill skill) {
        this.skills.remove(skill);
    }

    public String getName() {
        return this.name;
    }

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<Skill> skills) {
		this.skills = skills;
	}

	public void setName(String name) {
		this.name = name;
	}
}
