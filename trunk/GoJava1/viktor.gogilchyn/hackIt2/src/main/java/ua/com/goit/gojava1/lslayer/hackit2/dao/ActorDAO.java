package ua.com.goit.gojava1.lslayer.hackit2.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import ua.com.goit.gojava1.lslayer.hackit2.HackitIOException;
import ua.com.goit.gojava1.lslayer.hackit2.HackitWrongParameterException;
import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.actor.HumanControlledCharacter;

public class ActorDAO {
    private Actor actor = null;

    public ActorDAO(Actor actor) {
        this.actor = actor;
    }

    public Actor load(String actorName) throws HackitIOException,
            HackitWrongParameterException, IOException {
        File file = new File(actorName);
        Actor actor = new HumanControlledCharacter(actorName);
        BufferedReader actorReader = null;

        try {
            actorReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new HackitIOException("Such actor not found!", e);
        }
        if (!actorReader.readLine().equals(actorName)) {
            actorReader.close();
            throw new HackitIOException("Wrong file format");
        }
        String line;
        while ((line = actorReader.readLine()) != null) {
            if (line.contains("Skill:")) {
                String name = line.substring(7).split("/")[0];
                // It's a kind of Magic!
                // See save() method to know why 7
                int value = Integer.parseInt(line.substring(7).split("/")[1]);
                actor.addSkill(name);
                if (value > 1)
                    actor.incSkill(name, value - 1);
            }
            if (line.contains("Attribute:")) {
                String name = line.substring(11).split("/")[0];
                // See save() method to know why 11
                String value = line.substring(11).split("/")[1];
                actor.addAttribute(name, value);
            }
        }
        actorReader.close();
        return actor;

    }

    public void save() throws HackitIOException {
        String eol = System.getProperty("line.separator");
        File file = new File(actor.getName());
        FileWriter out = null;
        try {
            out = new FileWriter(file);
            out.write(actor.getName());
            for (Map.Entry<String, Integer> entry : actor.getSkills()
                    .entrySet()) {
                out.write(eol + "Skill: " + entry.getKey() + "/"
                        + entry.getValue());
            }
            for (Map.Entry<String, String> entry : actor.getAttributes()
                    .entrySet()) {
                out.write(eol + "Attribute: " + entry.getKey() + "/"
                        + entry.getValue());
            }
            out.close();
        } catch (Exception e) {
            throw new HackitIOException("Something in io", e);
        }
    }

}
