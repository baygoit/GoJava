package dao.io;

import java.io.File;

public class MyUtil {

    public File getFile(String fileName) {
        return new File(this.getClass().getResource(fileName).getFile());
    }

}
