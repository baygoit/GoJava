package view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.com.goit.gojava7.kickstarter.Launcher;
import view.ConsoleMock.ConfigurableInputStream;

import java.io.*;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

public class ConsoleViewTest {
    private PrintStream oldOut;
    private ByteArrayOutputStream out;
    private InputStream oldIn;
    private ConfigurableInputStream in;

    @Before
    public void setUpStreams() {
        oldIn = System.in;

        in = new ConfigurableInputStream();

        oldOut = System.out;

        out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));
    }

    @Test
    public void test() {
        in.add("h");
        Launcher.main(null);
        assertThat(out.toString(), startsWith("Hello! You are at Kickstarter.\r\n" +
                "\r\n"));
        assertThat(out.toString(), endsWith("\r\n" +
                "\r\n" +
                "Categories:\r\n" +
                "1. Art\r\n" +
                "2. Comics\r\n" +
                "3. Crafts\r\n" +
                "4. Dance\r\n" +
                "5. Design\r\n" +
                "6. Fashion\r\n" +
                "7. Film & Video\r\n" +
                "8. Food\r\n" +
                "9. Games\r\n" +
                "10. Journalism\r\n" +
                "11. Music\r\n" +
                "12. Photography\r\n" +
                "13. Publishing\r\n" +
                "14. Technology\r\n" +
                "15. Theater\r\n" +
                "\r\n" +
                "Please choose category number or enter \"h\" for help.\r\n" +
                "h\r\n" +
                "Help:\r\n" +
                "h - help\r\n" +
                "x or 0 - exit\r\n" +
                "c - list of categories\r\n" +
                "u - update\r\n" +
                "b - back\r\n" +
                "\r\n" +
                "Please make your choice (h/x/c/u/b).\r\n" +
                "\r\n"));
        out.reset();
    }

    @After
    public void cleanUpStreams() {
        System.setOut(oldOut);
        System.setIn(oldIn);
    }
}