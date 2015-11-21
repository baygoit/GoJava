package ua.com.goit.gojava7.kickstarter.dao.file.util;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
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
import java.util.regex.Pattern;

public class CsvParser {

    private String dateTimeFormat = "yyyy.MM.dd";
    private String delimiter = ";";
    private String lineSeparator = "\n";
    private Set<Class<?>> simpleTypes;
    private boolean hasHeader = true;
    private Map<String, ParserFromString<?>> parsersFromString = new HashMap<>();
    private Map<String, ParserToString<?>> parsersToString = new HashMap<>();

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

    public void setHasHeader(boolean hasHeader) {
        this.hasHeader = hasHeader;
    }

    public boolean hasHeader() {
        return hasHeader;
    }

    public void addParserFromString(String fieldName, ParserFromString<?> parser) {
        parsersFromString.put(fieldName.toLowerCase(), parser);
    }

    public void addParserToString(String fieldName, ParserToString<?> parser) {
        parsersToString.put(fieldName.toLowerCase(), parser);
    }

    public <T> void write(T element, String filePath) {
        List<T> list = new ArrayList<>();
        list.add(element);
        write(list, filePath);
    }

    public <T> void write(List<T> collection, String filePath) {
        if (!collection.isEmpty()) {
            Class<?> clazz = collection.get(0).getClass();

            try {
                writeToFile(collection, filePath, getFieldsDescription(clazz, MethodType.get));
            } catch (ReflectiveOperationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void clear(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getDataFile(filePath)));) {
            writer.write("");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private List<FieldDescription> getFieldsDescription(Class<?> clazz, MethodType methodType) {
        List<FieldDescription> methods = new ArrayList<>();

        for (Field field : clazz.getDeclaredFields()) {

            if (Collection.class.isAssignableFrom(field.getType()) || field.getType().isArray()) {
                continue;
            }

            String fieldName = field.getName();
            try {
                fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                Method method;

                switch (methodType) {
                case get:
                    method = clazz.getMethod(methodType + fieldName);
                    break;
                case set:
                    method = clazz.getMethod(methodType + fieldName, field.getType());
                    break;
                default:
                    continue;
                }

                methods.add(new FieldDescription(fieldName.toLowerCase(), field, method));

            } catch (ReflectiveOperationException e) {
             // TODO: handle exception
                e.printStackTrace();
            }
        }
        return methods;
    }

    private <T> void writeToFile(List<T> collection, String filePath, List<FieldDescription> descriptions)
            throws ReflectiveOperationException {

        ArrayList<T> list = filterUniques(collection);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getDataFile(filePath)));) {
            if (hasHeader) {
                for (FieldDescription entry : descriptions) {
                    writer.append(entry.name).append(delimiter);
                }
                writer.write(lineSeparator);
            }

            for (T element : list) {
                for (FieldDescription entry : descriptions) {
                    String fieldValue = getFieldValue(element, entry);
                    writer.append(fieldValue).append(delimiter);
                }
                writer.write(lineSeparator);
            }
        } catch (IOException e) {
            // TODO: handle exception
        }
    }

    private <T> ArrayList<T> filterUniques(List<T> collection) {
        return new ArrayList<>(new HashSet<>(collection));
    }

    private File getDataFile(String path) throws IOException {
        File file = new File(path);

        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        return file;
    }

    public <U> List<U> read(String filePath, Class<U> clazz) {
        List<U> list = new ArrayList<>();

        try {
            list = readFile(filePath, clazz);
        } catch (ReflectiveOperationException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }

        return filterUniques(list);
    }

    private <U> List<U> readFile(String filePath, Class<U> clazz) throws ReflectiveOperationException {

        List<U> list = new ArrayList<>();

        Constructor<U> defaultBeanConstructor = clazz.getDeclaredConstructor();
        List<FieldDescription> fieldDescriptions = getFieldsDescription(clazz, MethodType.set);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));) {
            if (hasHeader) {
                reader.readLine();
            }

            Pattern pattern = Pattern.compile(delimiter + "(?=([^\"]*\"[^\"]*\")*(?![^\"]*\"))");

            while (reader.ready()) {
                U newInstance = defaultBeanConstructor.newInstance();
                String[] split = pattern.split(reader.readLine());

                int i = 0;
                for (FieldDescription entry : fieldDescriptions) {
                    try {
                        String stringValue = split[i++].replaceAll("\"", "");
                        setFieldValue(newInstance, entry, stringValue);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
                list.add(newInstance);
            }

        } catch (IOException e) {
            // TODO: handle exception
        }

        return list;
    }

    private <U> void setFieldValue(U object, FieldDescription entry, String stringValue)
            throws ReflectiveOperationException {

        Object value;
        if (parsersFromString.get(entry.name) != null) {
            value = parsersFromString.get(entry.name).parse(stringValue);
        } else {
            value = stringToValue(entry.field.getType(), stringValue);
        }
        entry.method.invoke(object, value);

    }

    private <U> String getFieldValue(U object, FieldDescription entry) {
        String stringValue = "";
        try {
            Object value = entry.method.invoke(object);
            if (parsersToString.get(entry.name) != null) {
                stringValue = parsersToString.get(entry.name).parse(value, true);
            } else {
                stringValue = valueToString(value);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return stringValue;
    }

    private Object stringToValue(Class<?> targetType, String text) {
        try {
            if (targetType.equals(Date.class)) {
                return new SimpleDateFormat(dateTimeFormat).parse(text);
            } else {
                PropertyEditor editor = PropertyEditorManager.findEditor(targetType);
                editor.setAsText(text);
                return editor.getValue();
            }
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

    private <U> String valueToString(U value) {
        if (value == null) {
            return "";
        } else if (value.getClass().equals(String.class)) {
            return "\"" + value.toString() + "\"";
        } else if (value.getClass().isPrimitive() || simpleTypes.contains(value.getClass())) {
            return value.toString();
        } else if (value instanceof Date) {
            return new SimpleDateFormat(dateTimeFormat).format(value);
        }
        return "";
    }

    class FieldDescription {
        public final String name;
        public final Field field;
        public final Method method;

        public FieldDescription(String name, Field field, Method method) {
            this.name = name;
            this.field = field;
            this.method = method;
        }
    }

    enum MethodType {
        get, set
    }

    public interface ParserFromString<U> {
        U parse(String stringValue);
    }

    public interface ParserToString<U> {
        String parseValue(U value);

        @SuppressWarnings("unchecked")
        default String parse(Object value, boolean b) {
            return parseValue((U) value);
        };
    }
}
