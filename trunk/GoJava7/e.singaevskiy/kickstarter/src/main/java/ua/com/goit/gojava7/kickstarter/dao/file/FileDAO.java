package ua.com.goit.gojava7.kickstarter.dao.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonStreamParser;

import ua.com.goit.gojava7.kickstarter.dao.DataStorage;

public class FileDAO<T> implements DataStorage<T> {

    private static final String LINE_BREAK = "\n";
    private String pathToFile;
    private Class<T> persistentClass;
    private final int READ_ALL = -2;

    public FileDAO(Class<T> persistentClass) {
        this(persistentClass, "resources/storages/file/%name%.txt".replace("%name%", persistentClass.getSimpleName()));
    }
    
    public FileDAO(Class<T> persistentClass, String pathToFile) {
        this.pathToFile = pathToFile;
        this.persistentClass = persistentClass;
    }

    @Override
    public List<T> getAll() {

        String data = readData();

        List<T> elements = new ArrayList<>();
        
        if (!data.isEmpty()) {
            Gson g = getJsonParser();
            JsonStreamParser parser = new JsonStreamParser(data);
            parser.forEachRemaining(element -> elements.add(g.fromJson(element, persistentClass)));
        }

        return elements;
    }

    @Override
    public T get(int index) {
        
        String data = readData(index);

        T element = null;
        
        if (data != null) {
            Gson g = getJsonParser();
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(data);
            element = g.fromJson(jsonElement, persistentClass);
        }
        
        return element;
    }

    @Override
    public void add(T element) {
        Gson g = getJsonParser();
        String data = g.toJson(element);
        writeData(data, true);
    }

    private Gson getJsonParser() {
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        
        //gsonBuilder.setPrettyPrinting();
        gsonBuilder.serializeNulls();
        gsonBuilder.disableHtmlEscaping();
        gsonBuilder.disableInnerClassSerialization();
       // gsonBuilder.setDateFormat("yyyy.mm.dd");
        
        return gsonBuilder.create();
    }


    public void clear() {
        writeData("");
    }
    
    @Override
    public void addAll(List<T> elemens) {
        Gson g = getJsonParser();
        StringBuilder data = new StringBuilder();

        elemens.forEach(element -> data.append(g.toJson(element)).append(LINE_BREAK));
        
        writeData(data.toString());

    }

    private String readData() {
        return readData(READ_ALL);
    }
    
    private String readData(int readIndex) {

        StringBuilder data = new StringBuilder();
        BufferedReader br = getReader();

        if (br != null) {
            String line = "";
            try {
                for (int i = -1; line != null; i++) {
                    if (readIndex == READ_ALL || i == readIndex) {
                        data.append(line);
                    }
                    
                    if (i == readIndex) {
                        break;
                    }
                    
                    line = br.readLine();
                }

                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return data.toString();
    }
    
    private boolean writeData(String data) {
        return writeData(data, false);
    }
    
    private boolean writeData(String data, boolean append) {

        try {

            File file = getDataFile();

            FileWriter fw = new FileWriter(file.getAbsoluteFile(), append);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(data + (append ? LINE_BREAK : "") );
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

    private BufferedReader getReader() {
        BufferedReader br = null;
        try {
            File file = getDataFile();

            FileInputStream fis = new FileInputStream(file);
            br = new BufferedReader(new InputStreamReader(fis));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return br;

    }

}
