package dao.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class AbstractIODao {

    public void writeToFile(String file) throws IOException {
        BufferedWriter write = new BufferedWriter(new FileWriter(new File(file)));
    }

}
