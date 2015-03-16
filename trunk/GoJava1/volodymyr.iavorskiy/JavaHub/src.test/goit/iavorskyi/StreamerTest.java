package goit.iavorskyi;

import static org.junit.Assert.*;
import goit.iavorskyi.domain.FileWriterReader;

import org.junit.Test;

public class StreamerTest {

	@Test
	public void testWrite() {
		FileWriterReader.writeTextToFile("test string2");
	}

}
