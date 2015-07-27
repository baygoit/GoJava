package tyomsky.kickstarter.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tyomsky.kickstarter.model.QuoteGenerator;
import tyomsky.kickstarter.ui.IO;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class KickstarterTest {

    private static final int EXIT_CODE = 0;

    @Mock
    QuoteGenerator mockQuoteGenerator;

    @Mock
    IO mockIO;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

}