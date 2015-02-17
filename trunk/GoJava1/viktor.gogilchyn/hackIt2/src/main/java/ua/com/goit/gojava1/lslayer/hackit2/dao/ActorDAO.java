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
import ua.com.goit.gojava1.lslayer.hackit2.exception.HackitIOException;
import ua.com.goit.gojava1.lslayer.hackit2.exception.HackitWrongParameterException;

public class ActorDAO {
    private boolean isUnix = false;
    private static final String WIN_SAVE_DIR = "c:\\workspace\\Hackit2\\saved\\";
    private static final String UNIX_SAVE_DIR = "/usr/share/hackit2/";
    private static final String FILE_EXT = ".sav";
    private static final String SKILL_PREFIX = "Skill: ";
    private static final String ATTRIBUTE_PREFIX = "Attribute: ";
    private static final String DELIMITER = "/";

    public ActorDAO() {

    }

    public ActorDAO(boolean isUnix) {
        this.isUnix = isUnix;
    }

    public List<Actor> loadAll() {
        List<Actor> resultList = new LinkedList<Actor>();
        File folder = new File(WIN_SAVE_DIR);
        File[] listOfFiles = folder.listFiles(); // Now hindy-os-check will stay
        if (listOfFiles != null) {
            for (File currentFile : listOfFiles) {
                if (currentFile.isFile()
                        && currentFile.getName().endsWith(FILE_EXT)) {
                    try {
                        resultList.add(this.fromFile(currentFile.getName()
                                .substring(
                                        0,
                                        currentFile.getName().length()
                                                - FILE_EXT.length())));
                    } catch (Exception e) {
                    }
                }
            }
        }
        File folderUnix = new File(UNIX_SAVE_DIR);
        File[] listOfFilesUnix = folderUnix.listFiles();
        if (listOfFilesUnix != null) {
            for (File currentFile : listOfFilesUnix) {
                if (currentFile.isFile()
                        && currentFile.getName().endsWith(FILE_EXT)) {
                    try {
                        resultList.add(this.fromFile(currentFile.getName()
                                .substring(
                                        0,
                                        currentFile.getName().length()
                                                - FILE_EXT.length())));
                    } catch (Exception e) {
                    }
                }
            }
        }
        return resultList;
    }

    public Actor fromFile(String actorName) throws HackitIOException,
            HackitWrongParameterException, IOException {
        File file = new File(WIN_SAVE_DIR + actorName + FILE_EXT);
        if (!file.exists()) {
            file = new File(UNIX_SAVE_DIR + actorName + FILE_EXT);
            if (!file.exists()) {
                throw new HackitIOException("Such actor not found in win/nix block"
                        + file.getCanonicalPath());
            }
        }
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
                // See save() method to know why 11
                String value = currentLine.split(DELIMITER)[1];
                actor.addAttribute(name, value);
            }
        }
        actorReader.close();
        return actor;

    }

    public void save(Actor actor) throws HackitIOException, IOException {
        String eol = System.getProperty("line.separator");
        File file = new File((this.isUnix ? UNIX_SAVE_DIR : WIN_SAVE_DIR)
                + actor.getName() + FILE_EXT);
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
            throw new HackitIOException("Something in io" + file.getCanonicalPath()+file.getName(), e);
        }
    }

    public void delete(Actor gamer) throws HackitIOException {
        File file = new File(WIN_SAVE_DIR + gamer.getName() + FILE_EXT);
        if (!file.exists()) {
            file = new File(UNIX_SAVE_DIR + gamer.getName() + FILE_EXT);
            if (!file.exists()) {
                try {
                    throw new HackitIOException("Such actor not found! in delete"
                            + file.getCanonicalPath());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        file.delete();
    }

}
