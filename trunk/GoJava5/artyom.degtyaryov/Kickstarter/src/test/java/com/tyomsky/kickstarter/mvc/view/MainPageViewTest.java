package com.tyomsky.kickstarter.mvc.view;

import com.tyomsky.kickstarter.model.Category;
import com.tyomsky.kickstarter.model.Project;
import com.tyomsky.kickstarter.mvc.model.MainPageModel;
import com.tyomsky.kickstarter.ui.Output;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyCollection;
import static org.mockito.Matchers.anyCollectionOf;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainPageViewTest {

    @Mock
    Output output;

    @Mock
    MainPageModel model;

    @InjectMocks
    MainPageView view;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenShowThenInvokeOutputWithLayout() throws Exception {
        when(model.getQuote()).thenReturn("some quote");
        view.show(model);
        view.getLayout();
        verify(output, times(1)).print(view.getLayout());
    }
}
