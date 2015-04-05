package ua.goit.serialization;
import java.io.File;

import ua.goit.graphElements.*;

/**
 * Abstract class for serializer 
 */
public interface Serializer {
   StringBuilder serialize(Group element);
   StringBuilder serialize(Element element);
   void saveToFile(StringBuilder source, File file);
}
