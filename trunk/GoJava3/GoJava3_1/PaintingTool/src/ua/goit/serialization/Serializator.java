package ua.goit.serialization;
import java.io.File;

import ua.goit.graphElements.*;

/**
 * Abstract class for serializator 
 */
public abstract class Serializator {
    public abstract StringBuilder serialize(Group element);
    public abstract StringBuilder serialize(Element element);
    public abstract void saveToFile(StringBuilder source, File file);
}
