package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.dao.DaoMode;
import com.sandarovich.kickstarter.io.IO;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author Olexander Kolodiazhny 2016
 */
@Ignore
public class KickStartTest {

    @Test
    public void testMainMenu() {
        //given
        IO io = mock(IO.class);
        KickStarter kickStarter = new KickStarter(io, DaoMode.MEMORY);
        when(io.read()).thenReturn("1");

        //when
        kickStarter.run();

        //then
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(io, times(12)).write(captor.capture());

        assertEquals(
                "[=======================================, " +
                        "     Kickstarter emulator v.0.0.5, " +
                        "     by O.Kolodiazhny 2016      , " +
                        "=======================================, " +
                        "\"Every big journey begins with a small step\"\n" +
                        ", " +
                        "-----------, " +
                        "{0} Main Menu:, " +
                        "-----------, " +
                        "0 - Show categories, " +
                        "1 - Exit, " +
                        "---, " +
                        ">> Bye]"
                , captor.getAllValues().toString());
    }

}
