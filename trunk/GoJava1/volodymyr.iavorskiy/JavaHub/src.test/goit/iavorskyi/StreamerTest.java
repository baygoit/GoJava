package goit.iavorskyi;

import static org.junit.Assert.*;
import goit.iavorskyi.io.Streamer;

import org.junit.Test;

public class StreamerTest {

	@Test
	public void testWrite() {
		Streamer.write("test string2");
	}

}
