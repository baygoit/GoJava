package ua.com.goit.gojava7.kickstarter.dao.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.DataStorage;
import ua.com.goit.gojava7.kickstarter.dao.file.util.CsvParser;

public class FileDAO<T> implements DataStorage<T> {

    private static final String LINE_BREAK = "\n";
    private String pathToFile;
    private Class<T> persistentClass;
    CsvParser parser = new CsvParser();

    public FileDAO(Class<T> persistentClass) {
        this(persistentClass, "./kicks-files/%name%.CSV".replace("%name%", persistentClass.getSimpleName()));
    }

    public FileDAO(Class<T> persistentClass, String pathToFile) {
        this.pathToFile = pathToFile;
        this.persistentClass = persistentClass;

        parser.addParserFromString("project", stringValue -> new ProjectFileDAO().get(Integer.parseInt(stringValue)));
        parser.addParserFromString("category", stringValue -> new CategoryFileDAO().get(Integer.parseInt(stringValue)));

        parser.addParserToString("project", (Project value) -> String.valueOf(value.getId()));
        parser.addParserToString("category", (Category value) -> String.valueOf(value.getId()));
    }

    @Override
    public List<T> getAll() {

        CsvParser parser = getParser();
        List<T> elements = parser.read(pathToFile, persistentClass);

        return elements;
    }

    @Override
    public T get(int index) {

        T element = null;

        List<T> all = getAll();

        if (index < all.size()) {
            element = all.get(index);
        }

        return element;
    }

    @Override
    public void add(T element) {
        List<T> all = getAll();
        all.add(element);
        getParser().write(all, pathToFile);

    }

    public CsvParser getParser() {
        return parser;
    }

    public void clear() {
        writeData("");
    }

    @Override
    public void addAll(List<T> elements) {

        List<T> all = getAll();
        all.addAll(elements);
        CsvParser parser = getParser();
        parser.write(all, pathToFile);

    }

    private boolean writeData(String data) {
        return writeData(data, false);
    }

    private boolean writeData(String data, boolean append) {

        try {

            File file = getDataFile();

            FileWriter fw = new FileWriter(file.getAbsoluteFile(), append);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(data + (append ? LINE_BREAK : ""));
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    private File getDataFile() throws IOException {
        File file = new File(pathToFile);

        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        return file;
    }
}
