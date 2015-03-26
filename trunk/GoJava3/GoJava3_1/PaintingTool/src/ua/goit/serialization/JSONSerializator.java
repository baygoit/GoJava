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
    openCloseBracket(openBracket);
    addAttribute("Name", element.getName());
    addAttribute("Type", element.getType());
    addAttributeWithoutValue("Points");
    if (element.getPoints() != null) {
      getPointsFromElement(element);
    }
    openCloseBracket(closeBracket);
    return serializeString;
  }

  @Override
  public StringBuffer serialize(Group group) {

    if (isGropsNotNullAndNotEmpty(group)) {
      bufAppend(tab.toString() + group.getName() + " "
              + openBracket + enter);
      addTab();
      for (Group innerGroup : group.getGroups()) {
        serialize(innerGroup);
      }

      if (isGropsElementNotNullAndNotEmpty(group)) {
        for (Element element : group.getElements()) {
          serialize(element);
        }
      }
      remTab();
      openCloseBracket(closeBracket);
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
      new RuntimeException("Some Problems with file");
    }
  }

  private void addAttributeWithoutValue(String attribute) {
    bufAppend(tab.toString() + dQ + attribute + dQ + " : ");
  }

  private void getPointsFromElement(Element element) {
    bufAppend(openBracketS + enter);
    addTab();
    for (Point point : element.getPoints()) {
      addAttribute("Point", point.getCoordinate());
    }

    remTab();
    openCloseBracket(closeBracketS);

  }

  private void openCloseBracket(char bracket) {
    bufAppend(tab.toString() + bracket + enter);
  }

  private void addAttribute(String attribute, String value) {
    bufAppend(tab.toString() + dQ + attribute + dQ + " : "
            + dQ + value + dQ + enter);
  }

  private void remTab() {
    tab.delete(0, 4);
  }

  private void addTab() {
    tab.append(oneTab);
  }

  private boolean isGropsElementNotNullAndNotEmpty(Group group) {
    return group.getElements() != null || group.getElements().size() <= 0;
  }

  private boolean isGropsNotNullAndNotEmpty(Group group) {
    return group.getGroups() != null || group.getGroups().size() <= 0;
  }

  private void bufAppend(String text) {
    serializeString.append(text);
  }

}


