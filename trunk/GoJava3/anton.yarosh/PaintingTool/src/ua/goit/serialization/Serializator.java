package ua.goit.serialization;
import java.io.File;

import ua.goit.graphElements.*;

public abstract class Serializator {

    public abstract StringBuffer serialize(GraphElement element);
    public abstract void saveToFile(StringBuffer source, File file);
}
