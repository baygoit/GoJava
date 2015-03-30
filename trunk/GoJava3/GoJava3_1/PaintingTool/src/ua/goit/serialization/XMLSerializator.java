package ua.goit.serialization;

import ua.goit.graphElements.Element;
import ua.goit.graphElements.Group;
import ua.goit.graphElements.Point;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XMLSerializator extends Serializator {
    private StringBuffer buffer = new StringBuffer();

    @Override
    public StringBuffer serialize(Element element) {
            buffer.append("<" + element.getClass().getSimpleName() + ">" + element.getName());
            if (element.getPoints() == null) {
                buffer.append("<Points> </Points>");
            }
            else {
                buffer.append("<Points>");
                for (Point point : element.getPoints()) {
                    buffer.append("<Point>" + "<x>" + point.getX() + "</x>" + "<y>" + point.getY() + "</y>" + "</Point>");
                }
                buffer.append("</Points>");
            }
            buffer.append("</" + element.getClass().getSimpleName() + ">");

        return buffer;
    }

    @Override
    public StringBuffer serialize(Group group) {
        if (group.getGroups() != null || group.getGroups().size() <= 0 ) {
            buffer.append("<" + group.getType() + ">" + group.getName());
            for (Group inGroup : group.getGroups()) {
                serialize(inGroup);
            }
        }
        if (group.getElements() != null || group.getElements().size() <= 0) {
            for (Element element : group.getElements()) {
                serialize(element);
            }
        }
        buffer.append("</" + group.getType() + ">");

        return buffer;
    }

    @Override
    public void saveToFile(String source, File file) {
        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
            bw.write("<elements>");
            bw.write(source);
            bw.write("</elements>");
            bw.close();

        }catch (IOException e) {
            e.printStackTrace();
        }




    }

}