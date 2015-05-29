package kickstarter.view.reader;

import java.io.IOException;

public interface Reader {
	String getLine() throws IOException;
}
