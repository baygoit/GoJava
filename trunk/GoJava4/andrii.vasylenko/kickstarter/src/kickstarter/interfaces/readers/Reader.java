package kickstarter.interfaces.readers;

import java.io.IOException;

public interface Reader {
	String getLine() throws IOException;
}
