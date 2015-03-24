package ua.goit.testProject.serialization;

import ua.goit.testProject.data.Element;
import ua.goit.testProject.data.Group;

import java.io.File;

/**
 * Created by kossovec on 24.03.2015.
 */
public interface Serializer {
  public StringBuffer serializeElement(Element element);
  public StringBuffer serializeGroup(Group group);
  public void saveToFile(StringBuffer source, File file);
}
