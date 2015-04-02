package ua.goit.serialization;

import ua.goit.graphElements.Element;
import ua.goit.graphElements.Group;
import ua.goit.graphElements.Point;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XMLSerializator extends Serializator {
    private StringBuffer buffer = null;
    
  private XMLSerializator() {
    buffer = new StringBuffer();
  }

    public  void openGroupTagWithAttr(Group group) {
	buffer.append("<");
	buffer.append(group.getType());
	buffer.append(" name");
	buffer.append("=\"");
	buffer.append(group.getName());
	buffer.append("\">");
    }

    public void openElementTagWithAttr(Element element) {
	buffer.append("<");
	buffer.append(element.getClass().getSimpleName());
	buffer.append(" name");
	buffer.append("=\"");
	buffer.append(element.getName());
	buffer.append("\">");
    }

    @Override
    public StringBuffer serialize(Element element) {
	openElementTagWithAttr(element);
	if (element.getPoints() == null) {
	    buffer.append("<Points> </Points>");
	}
	else {
	    buffer.append("<Points>");
	    for (Point point : element.getPoints()) {
		buffer.append("<Point>");
		buffer.append("<x>");
		buffer.append(point.getX());
		buffer.append("</x>");
		buffer.append("<y>");
		buffer.append(point.getY());
		buffer.append("</y>");
		buffer.append("</Point>");
	    }
	    buffer.append("</Points>");
	}

	buffer.append("</");
	buffer.append(element.getClass().getSimpleName());
	buffer.append(">");
	return buffer;
    }

    @Override
    public StringBuffer serialize(Group group) {
	if (group.getGroups() != null || group.getGroups().size() <= 0 ) {
	    openGroupTagWithAttr(group);
	    for (Group inGroup : group.getGroups()) {
		serialize(inGroup);
	    }
	}
	if (group.getElements() != null || group.getElements().size() <= 0) {
	    for (Element element : group.getElements()) {
		serialize(element);
	    }
	}

	buffer.append("</");
	buffer.append(group.getType());
	buffer.append(">");
	return buffer;
    }

    @Override
    public void saveToFile(StringBuffer source, File file) {
	try {
	    FileWriter fw = new FileWriter(file.getAbsoluteFile());
	    BufferedWriter bw = new BufferedWriter(fw);
	    bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
	    bw.write("<elements>");
	    bw.write(source.toString());
	    bw.write("</elements>");
	    bw.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}