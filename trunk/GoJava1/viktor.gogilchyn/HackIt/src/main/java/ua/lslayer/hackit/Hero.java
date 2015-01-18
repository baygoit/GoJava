package ua.lslayer.hackit;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "hero")
@XmlType(propOrder = { "name", "skill" })
public class Hero {
	@XmlElementWrapper (name = "skills")
    private List<Skill> skill;
	private String name;
    

	public Hero() {
	}

	public Hero(String name) {
        this.name = name;
        this.skill = new ArrayList<Skill>();
    }
    
    public String listSkills() {
        String eol = System.getProperty("line.separator");  
        String returnValue = new String();
        for (Skill element : this.skill) {
            returnValue += element;
            returnValue += eol;
        }
        return returnValue;
    }
    
    public void addSkill(Skill skill) {
        this.skill.add(skill);
    }
    
    public void removeSkill(Skill skill) {
        this.skill.remove(skill);
    }

    public String getName() {
        return this.name;
    }

	public List<Skill> getSkills() {
		return skill;
	}

	public void setSkills(ArrayList<Skill> skills) {
		this.skill = skills;
	}

	public void setName(String name) {
		this.name = name;
	}
}
