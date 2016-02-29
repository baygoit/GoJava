package anagrams;

import java.io.IOException;

public interface IO {

	public String read() throws IOException;
	public void write(String str);
}
