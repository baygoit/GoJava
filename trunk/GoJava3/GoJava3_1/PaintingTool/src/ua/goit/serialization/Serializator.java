package ua.goit.serialization;
import java.io.File;

import ua.goit.graphElements.*;

public abstract class Serializator {

    public abstract StringBuffer serialize(Group element);
    public abstract StringBuffer serialize(Element element);
    public abstract void saveToFile(StringBuffer source, File file);
}
