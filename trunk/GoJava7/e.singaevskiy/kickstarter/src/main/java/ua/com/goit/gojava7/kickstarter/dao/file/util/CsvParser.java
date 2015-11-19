package ua.com.goit.gojava7.kickstarter.dao.file.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CsvParser {

    private String dateTimeFormat = "yyyy.MM.dd";
    private String delimiter = ";";
    private String lineSeparator = "\n";
    private Set<Class<?>> simpleTypes;

    public CsvParser() {
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
            throws ReflectiveOperationException, IOException {
        List<T> list = new ArrayList<>();
        list.add(element);
        write(list, filePath);
    }

    public <T> void write(List<T> collection, String filePath)
            throws IOException, ReflectiveOperationException {

        if (!collection.isEmpty()) {
            Class<?> clazz = collection.get(0).getClass();
            
            Map<String, Method> methods = getMethods(clazz, "get");

            writeToFile(collection, filePath, methods);
        }
        
    }
    
    private Map<String, Method> getMethods(Class<?> clazz, String methodType){
        Map<String, Method> methods = new HashMap<>();

        for (Field field : clazz.getDeclaredFields()) {

            if (Collection.class.isAssignableFrom(field.getType()) || field.getType().isArray()) {
                continue;
            }

            String name = field.getName();
            try {
                name = name.substring(0, 1).toUpperCase() + name.substring(1);
                Method method;
                
                if (methodType.equals("get")) {
                    method = clazz.getMethod(methodType + name);
                }else {
                    method = clazz.getMethod(methodType + name, field.getType());
                }
                
                methods.put(name.toLowerCase(), method);

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(name + " not found");
            }
        }
        return methods;
    }

    private <T> void writeToFile(List<T> collection, String filePath, Map<String, Method> methods)
            throws IOException, ReflectiveOperationException {
        
        StringBuilder header = new StringBuilder();
        for (String fieldName : methods.keySet()) {
            header.append(fieldName).append(delimiter);
        }
        header.append(lineSeparator);
       
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(getDataFile(filePath)));
        writer.write(header.toString());

        for (T element : collection) {
            System.out.println(element);
            for (Method method : methods.values()) {
                Object value = method.invoke(element);

                if (value.getClass().isPrimitive() || simpleTypes.contains(value.getClass())) {
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
