package kickstarter.reader;

import java.io.IOException;

public interface Reader {

    int readUserInput();
    
    public String readline() throws IOException;

}
