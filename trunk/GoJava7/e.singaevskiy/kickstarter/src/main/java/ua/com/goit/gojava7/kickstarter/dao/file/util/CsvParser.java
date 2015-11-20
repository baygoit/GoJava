package ua.com.goit.gojava7.kickstarter.dao.file.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CsvParser {

    private String dateTimeFormat = "yyyy.MM.dd";
    private String delimiter = ";";
    private String lineSeparator = "\n";
    private Class<?> clazz;
    private Set<Class<?>> simpleTypes;

    public CsvParser(Class<?> clazz) {
        this.clazz = clazz;

        simpleTypes = new HashSet<>();
        simpleTypes.add(String.class);
        simpleTypes.add(Integer.class);
        simpleTypes.add(Long.class);
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getLineSeparator() {
        return lineSeparator;
    }

    public void setLineSeparator(String lineSeparator) {
        this.lineSeparator = lineSeparator;
    }

    public String getDateTimeFormat() {
        return dateTimeFormat;
    }

    public void setDateTimeFormat(String dateTimeFormat) {
        this.dateTimeFormat = dateTimeFormat;
    }

    public <T> void write(T element, String filePath)
            throws IllegalAccessException, InvocationTargetException, IOException {
        List<T> list = new ArrayList<>();
        list.add(element);
        write(list, filePath);
    }

    public <T> void write(List<T> collection, String filePath)
            throws IOException, IllegalAccessException, InvocationTargetException {

        List<Method> getters = new ArrayList<>();
        List<Method> setters = new ArrayList<>();

        StringBuilder header = new StringBuilder();
        for (Field field : clazz.getDeclaredFields()) {

            if (Collection.class.isAssignableFrom(field.getType()) || field.getType().isArray()) {
                continue;
            }

            String name = "";
            try {
                name = field.getName();
                name = name.substring(0, 1).toUpperCase() + name.substring(1);
                Method setter = clazz.getMethod("set" + name, field.getType());
                setters.add(setter);
                Method getter = clazz.getMethod("get" + name);
                getters.add(getter);

                header.append(name).append(delimiter);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(name + " not found");
            }
        }

        writeToFile(collection, filePath, getters, header);
    }

    private <T> void writeToFile(List<T> collection, String filePath, List<Method> getters, StringBuilder header)
            throws IOException, IllegalAccessException, InvocationTargetException {
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(getDataFile(filePath)));
        writer.write(header.append(lineSeparator).toString());

        for (T element : collection) {
            for (Method method : getters) {
                Object value = method.invoke(element);

                if (simpleTypes.contains(value.getClass())) {
                    writer.write("\"" + value.toString() + "\"");
                } else if (value instanceof Date) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateTimeFormat);
                    writer.write("\"" + simpleDateFormat.format(value) + "\"");
                } else {

                    try {
                        Object id = value.getClass().getMethod("getId").invoke(value);
                        writer.write("\"" + id.toString() + "\"");
                    } catch (Exception e) {
                        writer.write("\"" + value.toString() + "\"");
                        System.err.println(value.getClass() + " does not have method 'getId'");
                    }
                }

                writer.write(delimiter);

            }
            writer.write(lineSeparator);
        }
        writer.close();
    }

    private File getDataFile(String path) throws IOException {
        File file = new File(path);

        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        return file;
    }
}
