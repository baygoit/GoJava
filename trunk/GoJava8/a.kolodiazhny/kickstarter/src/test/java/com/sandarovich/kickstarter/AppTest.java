package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.io.ConsoleIO;
import com.sandarovich.kickstarter.io.IO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Olexander Kolodiazhny 2016
 *
 *  Simple tests
 *
 */

public class AppTest {

    private final IO io = new ConsoleIO();
    private ConsoleMock console = new ConsoleMock();

    @Test
    public void testMainMenu() {
        //given
        console.addIn("0");
        KickStarter kickStarter = new KickStarter(io);

        //when
        kickStarter.start();

        //then
        assertEquals("=======================================\n" +
                "     Kickstarter emulator v.0.0.5\n" +
                "     by O.Kolodiazhny 2016      \n" +
                "=======================================\n" +
                "\"Every big journey begins with a small step\"\n" +
                "\n" +
                "-----------\n" +
                "{0} Main Menu:\n" +
                "-----------\n" +
                "1 - Show categories\n" +
                "0 - Exit\n" +
                "---\n" +
                "0\n" +
                ">> Bye\n", console.getOut());
    }

    @Test
    public void testGoToCategory() {
        //given
        console.addIn("1");
        console.addIn("0");
        console.addIn("0");
        KickStarter kickStarter = new KickStarter(io);

        //when
        kickStarter.start();

        //then

        assertEquals("=======================================\n" +
                "     Kickstarter emulator v.0.0.5\n" +
                "     by O.Kolodiazhny 2016      \n" +
                "=======================================\n" +
                "\"Every big journey begins with a small step\"\n" +
                "\n" +
                "-----------\n" +
                "{0} Main Menu:\n" +
                "-----------\n" +
                "1 - Show categories\n" +
                "0 - Exit\n" +
                "---\n" +
                "1\n" +
                "-----------\n" +
                "{1} Сategories:\n" +
                "-----------\n" +
                "1 - IT\n" +
                "2 - Tourism\n" +
                "0 - Exit\n" +
                "---\n" +
                "0\n" +
                "-----------\n" +
                "{0} Main Menu:\n" +
                "-----------\n" +
                "1 - Show categories\n" +
                "0 - Exit\n" +
                "---\n" +
                "0\n" +
                ">> Bye\n", console.getOut());
    }

    @Test
    public void testToProjectMenu() {
        //given
        KickStarter kickStarter = new KickStarter(io);
        console.addIn("1");
        console.addIn("0");

        //when

        kickStarter.start();

        //then

        assertEquals("", console.getOut());
    }

}
