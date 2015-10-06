package home_work.parsing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

public class ParsingTest  {
    @Before
    public void setUp() throws IOException {
        BufferedReader fin = new BufferedReader( new InputStreamReader(new FileInputStream(
                "C:\\Java\\GoJava\\trunk\\GoJava6\\vshcherbak\\intro\\src\\main\\java\\home_work\\parsing\\input.txt")));
    }

    @Test
    public void testMyList(BufferedReader fin) {
        Parsing parsing = new Parsing();
        String test = "110 Nikolay 2\n" +
                "111 Dima 8\n" +
                "112 Elena 10\n" +
                "113 Egor 9\n" +
                "114 Elena 5\n" +
                "115 Nikolay 7\n" +
                "116 Igor 6\n" +
                "117 Egor 4\n" +
                "118 Dima 3\n" +
                "119 Igor 1";
        parsing.parser(fin);
        String result = parsing.getEmployes();
        assertEquals(test, result);
    }
    @After
    public void finish(BufferedReader fin) throws IOException {
        fin.close();
    }
}
