package ua.com.goit.gojava1.lslayer.hackit2.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.actor.HumanControlledCharacter;
import ua.com.goit.gojava1.lslayer.hackit2.exception.HackitEcxeptionForUI;
import ua.com.goit.gojava1.lslayer.hackit2.exception.HackitIOException;

public class ActorFileDAO extends AbstractFileDAO {

    public ActorFileDAO() {

    }

    public List<Actor> loadAll() throws HackitEcxeptionForUI {
        List<Actor> resultList = new LinkedList<Actor>();
        File folder = new File(getSavePath());
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles == null)
            return null;
        for (File currentFile : listOfFiles) {
            if (currentFile.isFile()
                && currentFile.getName().endsWith(FILE_EXT)) {
                try {
                    resultList.add(this.fromFile(getActorNameFromFile(currentFile)));
                } catch (Exception e) {
                    // TODO Find out exception throw and continue execution
                    // throw new HackitEcxeptionForUI(e.getMessage());
                }
            }
        }
        return resultList;
    }

    public Actor fromFile(String actorName) throws HackitIOException, IOException {
        File file = new File(getSavePath() + actorName + FILE_EXT);
        if (!file.exists()) {
            throw new HackitIOException("Such actor not found in win/nix block"
                                        + file.getCanonicalPath());
        }
        Actor actor = new HumanControlledCharacter(actorName);
        BufferedReader actorReader = null;
        try {
            actorReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new HackitIOException("File read error!", e);
        }
        if (!actorReader.readLine().equals(actorName)) {
            actorReader.close();
            throw new HackitIOException("Wrong file format");
        }
        String line;
        while ((line = actorReader.readLine()) != null) {
            if (line.startsWith(SKILL_PREFIX)) {
                String currentLine = line.substring(SKILL_PREFIX.length());
                String name = currentLine.split(DELIMITER)[0];
                int value = Integer.parseInt(currentLine.split(DELIMITER)[1]);
                actor.addSkill(name);
                if (value > 1)
                    actor.incSkill(name, value - 1);
            }
            if (line.startsWith(ATTRIBUTE_PREFIX)) {
                String currentLine = line.substring(ATTRIBUTE_PREFIX.length());
                String name = currentLine.split("/")[0];
                String value = currentLine.split(DELIMITER)[1];
                actor.addAttribute(name, value);
            }
        }
        actorReader.close();
        return actor;

    }

    public void save(Actor actor) throws HackitIOException, IOException {
        String eol = System.getProperty("line.separator");
        File file = new File((getSavePath()) + actor.getName() + FILE_EXT);
        FileWriter out = null;
        try {
            out = new FileWriter(file);
            out.write(actor.getName());
            for (Map.Entry<String, Integer> entry : actor.getSkills()
                                                         .entrySet()) {
                out.write(eol + SKILL_PREFIX + entry.getKey() + "/"
                          + entry.getValue());
            }
            for (Map.Entry<String, String> entry : actor.getAttributes()
                                                        .entrySet()) {
                out.write(eol + ATTRIBUTE_PREFIX + entry.getKey() + "/"
                          + entry.getValue());
            }
            out.close();
        } catch (Exception e) {
            throw new HackitIOException("Something in io" + file.getCanonicalPath() + file.getName(), e);
        }
    }

    public void delete(Actor gamer) throws HackitIOException {
        File file = new File((getSavePath()) + gamer.getName() + FILE_EXT);
        if (file.exists()) {
            try {
                file.delete();
            } catch (Exception e) {
                throw new HackitIOException("Such actor not found! in delete");
            }
        }
    }

}
