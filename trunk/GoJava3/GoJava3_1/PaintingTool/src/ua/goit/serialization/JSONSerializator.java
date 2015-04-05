package ua.goit.serialization;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import ua.goit.graphElements.Element;
import ua.goit.graphElements.Group;

/**
 * you need to create new copy per serialize operation
 */
public class JSONSerializator extends Serializator {
  private StringBuilder tab = new StringBuilder();
  private StringBuilder zeroTab = new StringBuilder();
  private static final String ONE_TAB = "    ";
  private static final String ENTER = "\n";
  private static final char D_Q = '"';
  private static final char OPEN_BRACKET = '{';
  private static final char CLOSE_BRACKET = '}';
  private static final char OPEN_BRACKET_S = '[';
  private static final char CLOSE_BRACKET_S = ']';
  private StringBuilder serializeString = new StringBuilder("{" + ENTER + ENTER + "}");

  @Override
  public StringBuilder serialize(Element element) {
    addJSONObjectName(element.getName());
    openCloseBracket(zeroTab, OPEN_BRACKET, ENTER);
    addAttribute("Name", element.getName());
    addAttribute("Type", element.getClass().getSimpleName());
    addAttributeWithoutValue("Points");
    if (element.getPoints() != null) {
      serializePointsFromElement(element);
    }

    bufAppend(tab.toString() + CLOSE_BRACKET + "");
    return serializeString;
  }

  @Override
  public StringBuilder serialize(Group group) {
    addJSONObjectName(group.getName());
    openCloseBracket(zeroTab, OPEN_BRACKET, ENTER);
    if (hasGroup(group)) {
      addTab();
      int groupQuantity = group.getGroups().size();
      for (int i = 0; i < groupQuantity; i++) {
        serialize(group.getGroups().get(i));
        if (groupQuantity - 1 != i) {
          commaAppend();
        }
      }

      if (hasElements(group)) {
        commaAppend();
      } else {
        enterAppend();
      }
    }

    if (hasElements(group)) {
      int elementQuantity = group.getElements().size();
      for (int i = 0; i < elementQuantity; i++) {
        serialize(group.getElements().get(i));
        if (elementQuantity - 1 != i) {
          commaAppend();
        }
      }

      enterAppend();
    }

    remTab();
    openCloseBracket(tab, CLOSE_BRACKET, "");
    return serializeString;
  }

  @Override
  public void saveToFile(StringBuilder source, File file) {
    try {
      FileWriter fileForWrite = new FileWriter(file.getAbsoluteFile());
      fileForWrite.write(source.toString());
      fileForWrite.close();
    } catch (IOException e) {
      throw new RuntimeException("Some Problems with file");
    }
  }

  private void enterAppend() {
    bufAppend(ENTER);
  }

  private void commaAppend() {
    bufAppend("," + ENTER);
  }

  private void addJSONObjectName(String name) {
    bufAppend(tab.toString() + D_Q + name + D_Q + ":");
  }

  private void addAttributeWithoutValue(String attribute) {
    bufAppend(tab.toString() + D_Q + attribute + D_Q + " : ");
  }

  private void serializePointsFromElement(Element element) {
    bufAppend(OPEN_BRACKET_S + ENTER);
    addTab();
    int pointsQuantity = element.getPoints().size();
    for (int i = 0; i < pointsQuantity; i++) {
      int xCoordinate = element.getPoints().get(i).getX();
      int yCoordinate = element.getPoints().get(i).getY();
      openCloseBracket(tab, OPEN_BRACKET, ENTER);
      addAttribute("X", String.valueOf(xCoordinate));
      addAttributeLast("Y", String.valueOf(yCoordinate));
      openCloseBracket(tab, CLOSE_BRACKET, "");
      if (pointsQuantity - 1 != i) {
        commaAppend();
      }
    }

    enterAppend();
    remTab();
    openCloseBracket(tab, CLOSE_BRACKET_S, ENTER);
  }

  private void openCloseBracket(StringBuilder tab, char bracket, String enter) {
    bufAppend(tab.toString() + bracket + enter);
  }

  private void addAttribute(String attribute, String value) {
    bufAppend(tab.toString() + D_Q + attribute + D_Q + " : "
            + D_Q + value + D_Q + "," + ENTER);
  }

  private void addAttributeLast(String attribute, String value) {
    bufAppend(tab.toString() + D_Q + attribute + D_Q + " : "
            + D_Q + value + D_Q + ENTER);
  }

  private void remTab() {
    tab.delete(0, 4);
  }

  private void addTab() {
    tab.append(ONE_TAB);
  }

  private boolean hasElements(Group group) {
    return group.getElements() != null && group.getElements().size() > 0;
  }

  private boolean hasGroup(Group group) {
    return group.getGroups() != null && group.getGroups().size() > 0;
  }

  private void bufAppend(String data) {
    serializeString.insert(serializeString.length() - 2, data);
  }
}





