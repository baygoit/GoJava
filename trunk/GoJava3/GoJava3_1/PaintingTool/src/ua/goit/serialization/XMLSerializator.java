package ua.goit.serialization;
import ua.goit.graphElements.GraphElement;

import java.io.*;

public class XMLSerializator extends Serializator {
    private StringBuffer buffer = new StringBuffer();

    @Override
    public StringBuffer serialize(GraphElement element) {
        if (element.isElement()) {
            buffer.append("<" + element.getType() + ">" + element.getName());
            for (Point point : element.getPoints()) {
                buffer.append("<Point>" + point + "</Point>");
            }
            buffer.append("</" + element.getType() + ">");
        } else {
            buffer.append("<" + element.getType() + ">" + element.getName());
            for (GraphElement node : element) {
                serialize(element);
            }
            buffer.append("</" + element.getType() + ">");
        }
	    return buffer;
    }

    @Override
    public void saveToFile(StringBuffer source, File file) {
        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
            bw.write("<elements>");
            bw.write(source.toString());
            bw.write("</elements");
            bw.close();

        }catch (IOException e) {
            e.printStackTrace();
        }



	
    }

}
