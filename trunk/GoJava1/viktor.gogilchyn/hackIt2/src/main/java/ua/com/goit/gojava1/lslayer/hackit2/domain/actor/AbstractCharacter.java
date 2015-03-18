package ua.com.goit.gojava1.lslayer.hackit2.domain.actor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava1.lslayer.hackit2.domain.HackitWrongParameterException;
import ua.com.goit.gojava1.lslayer.hackit2.domain.action.Action;
import ua.com.goit.gojava1.lslayer.hackit2.domain.action.ActionParameters;
import ua.com.goit.gojava1.lslayer.hackit2.domain.action.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.domain.gear.Gear;

public abstract class AbstractCharacter implements Actor, Serializable, Positionable {

    private static final long serialVersionUID = -2511742480639362123L;
    private List<Attribute> atrributes = new ArrayList<Attribute>();
    private List<Gear> ControlList = new ArrayList<Gear>();
    private long id;
    private String name;
    private Position position;
    private List<Gear> possesionsList = new ArrayList<Gear>();
    private List<Skill> skills = new ArrayList<Skill>();

    public AbstractCharacter() {

    }

    public AbstractCharacter(String name) {
        this.name = name;
    }

    @Override
    public ActionResult act(Action whatToDo) throws HackitWrongParameterException {
        ActionParameters po = whatToDo.getParameters();
        po.actor = this;
        whatToDo.setParameters(po);
        return whatToDo.execute();
    }

    public void addAttribute(String what, String value) {
        this.atrributes.add(new Attribute(what, value));
    }

    public void addSkill(String skillName) {
        if ((this.getSkill(skillName) == 0) && (skillName != null)) {
            this.skills.add(new Skill(skillName, 1));
        }
    }

    public List<Attribute> getAtrributes() {
        return this.atrributes;
    }

    public String getAttributeValue(String what) { // Right now I don't need
                                                   // null in result.
        return null;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    public int getSkill(String skillName) {
        for (Skill element : this.skills) {
            if (element.getName().equals(skillName)) {
                return element.getValue();
            }
        }
        return 0;
    }

    public List<Skill> getSkills() {
        return this.skills;
    }

    @Override
    public int getSkillValue(String skillName) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void moveTo(Position position) {
        this.position = position;
    }

    public void setAtrributes(List<Attribute> atrributes) {
        this.atrributes = atrributes;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;

    }

    @Override
    public void setPosition(Position where) {
        this.position = where;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Actor [name=" + this.name + ", skills=" + this.skills + "]";
    }

}
