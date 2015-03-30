package ua.goit.serialization;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import ua.goit.graphElements.Element;
import ua.goit.graphElements.Group;

public class JSONSerializator extends Serializator {
  private StringBuffer tab = new StringBuffer();
  private StringBuffer zeroTab = new StringBuffer();
  private String oneTab = "    ";
  private String enter = "\n";
  private char dQ = '"';
  private char openBracket = '{';
  private char closeBracket = '}';
  private char openBracketS = '[';
  private char closeBracketS = ']';
  private StringBuffer serializeString = new StringBuffer("{" + enter + enter+ "}");

  @Override
  public StringBuffer serialize(Element element) {
    addJSONObjectName(element.getName());
    openCloseBracket(zeroTab, openBracket, enter);
    addAttribute("Name", element.getName());
    addAttribute("Type", element.getClass().getSimpleName());
    addAttributeWithoutValue("Points");
    if (element.getPoints() != null) {
      getPointsFromElement(element);
    }
    bufAppend(tab.toString() + closeBracket + "");
    return serializeString;
  }

  @Override
  public StringBuffer serialize(Group group) {
    addJSONObjectName(group.getName());
    openCloseBracket(zeroTab, openBracket, enter);
    if (isGropsNotNullAndNotEmpty(group)) {
      addTab();
      int gropeQuantity = group.getGroups().size();
      for (int i = 0; i < gropeQuantity; i++) {
        serialize(group.getGroups().get(i));
        if (gropeQuantity - 1 != i) {
          bufAppend("," + enter);
        }
      }

      if (isGropsElementNotNullAndNotEmpty(group)) {
        bufAppend("," + enter);
      } else {
        bufAppend(enter);
      }
    }

    if (isGropsElementNotNullAndNotEmpty(group)) {
      int elementQuantity = group.getElements().size();
      for (int i = 0; i < elementQuantity; i++) {
        serialize(group.getElements().get(i));
        if (elementQuantity - 1 != i) {
          bufAppend("," + enter);
        }
      }

      bufAppend(enter);
    }

    remTab();
    openCloseBracket(tab, closeBracket, "");
    return serializeString;
  }

  @Override
  public void saveToFile(StringBuffer source, File file) {
    try {
      FileWriter fileForWrite = new FileWriter(file.getAbsoluteFile());
      fileForWrite.write(source.toString());
      fileForWrite.close();
    } catch (IOException e) {
      throw new RuntimeException("Some Problems with file");
    }

  }

  private void addJSONObjectName(String name) {
    bufAppend(tab.toString() + dQ + name + dQ + ":");
  }

  private void addAttributeWithoutValue(String attribute) {
    bufAppend(tab.toString() + dQ + attribute + dQ + " : ");
  }

  private void getPointsFromElement(Element element) {
    bufAppend(openBracketS + enter);
    addTab();
    int pointsQuantity = element.getPoints().size();

    for (int i = 0; i < pointsQuantity; i++) {
      openCloseBracket(tab, openBracket, enter);
      addAttribute("X", String.valueOf(element.getPoints().get(i).getX()));
      addAttributeLast("Y", String.valueOf(element.getPoints().get(i).getY()));
      openCloseBracket(tab, closeBracket, "");
      if (pointsQuantity - 1 != i) {
        bufAppend("," + enter);
      }
    }
    bufAppend(enter);
    remTab();
    openCloseBracket(tab, closeBracketS, enter);

  }

  private void openCloseBracket(StringBuffer tab, char bracket, String enter) {
    bufAppend(tab.toString() + bracket + enter);
  }

  private void addAttribute(String attribute, String value) {
    bufAppend(tab.toString() + dQ + attribute + dQ + " : "
            + dQ + value + dQ + "," + enter);
  }

  private void addAttributeLast(String attribute, String value) {
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
    return group.getElements() != null && group.getElements().size() > 0;
  }

  private boolean isGropsNotNullAndNotEmpty(Group group) {
    return group.getGroups() != null && group.getGroups().size() > 0;
  }

  private void bufAppend(String data) {
    serializeString.insert(serializeString.length() - 2, data);
  }

}





