package ua.com.goit.gojava1.lslayer.hackit2.dao;

import java.io.File;

public abstract class AbstractDAO {
    protected static final String WIN_SAVE_DIR = "c:\\workspace\\Hackit2\\saved\\";
    protected static final String UNIX_SAVE_DIR = "/usr/share/hackit2/";
    protected static final String FILE_EXT = ".sav";
    protected static final String SKILL_PREFIX = "Skill: ";
    protected static final String ATTRIBUTE_PREFIX = "Attribute: ";
    protected static final String DELIMITER = "/";

    protected String getActorNameFromFile(File file) {
        return file.getName().substring(0, file.getName().length()
                                           - FILE_EXT.length());
    }

    protected boolean isUnix() {
        return !System.getProperty("os.name").toLowerCase().contains("win");
    }

    protected String getSavePath() {
        return isUnix() ? UNIX_SAVE_DIR : WIN_SAVE_DIR;
    }

}
