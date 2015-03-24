package ua.goit.serialization;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import ua.goit.graphElements.Element;

import ua.goit.graphElements.Group;
import ua.goit.graphElements.Point;

public class JSONSerializator extends Serializator {
  private StringBuffer serializeString = new StringBuffer();
  private StringBuffer tab = new StringBuffer();
  private String oneTab = "    ";
  private String enter = "\n";
  private char dQ = '"';
  private char openBracket = '{';
  private char closeBracket = '}';
  private char openBracketS = '[';
  private char closeBracketS = ']';
  @Override
  public StringBuffer serialize(Element element) {

    tab.append(oneTab);
    bufAppend(tab.toString() + openBracket + enter);
    bufAppend(tab.toString() + dQ + "Name" + dQ + " : "
            + element.getName() + enter);
    bufAppend(tab.toString() + dQ + "Type" + dQ + " : "
            + element.getType() + enter);
    bufAppend(tab.toString() + dQ + "Points" + dQ + " : ");
    if (element.getPoints() != null) {
      bufAppend(openBracketS + enter);
      tab.append(oneTab);
      for (Point point : element.getPoints()) {
        bufAppend(tab.toString() + dQ + "Point" + dQ + " : "
                + point.getCoordinate() + enter);
      }

      tab.delete(0, 4);
      bufAppend(tab.toString() + closeBracketS + enter);
    }
    return serializeString;
  }

  @Override
  public StringBuffer serialize(Group group) {

    if (group.getElements() != null) {
      for (Element element : group.getElements()) {
        serialize(element);
      }
    }
    if (group.getGroups() != null) {
      bufAppend(tab.toString() + group.getName() + " "
              + openBracket + enter);
      tab.append(oneTab);
      for (Group innerGroup : group.getGroups()) {
        serialize(innerGroup);
      }

      tab.delete(0, 4);
      bufAppend(tab.toString() + closeBracket + enter);
    }

    return serializeString;
  }

  @Override
  public void saveToFile(StringBuffer source, File file) {
    try {
      FileWriter fileForWrite = new FileWriter(file.getAbsoluteFile());
      fileForWrite.write(source.toString());
      fileForWrite.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void bufAppend(String text) {
    serializeString.append(text);
  }

}


