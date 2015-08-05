package nikfisher.kickstarter.model;

import nikfisher.kickstarter.Runner;
import nikfisher.kickstarter.streams.ConsoleInterfaceIO;
import org.junit.Test;

import java.util.Random;

import static org.mockito.Mockito.*;

public class QuoteGenerateTest {

    @Test
    public void shouldMenuWithProjectDetail() {
        //given
        ConsoleInterfaceIO io = mock(ConsoleInterfaceIO.class);
        QuoteGenerate generator = mock(QuoteGenerate.class);
        Random random = mock(Random.class);
        Runner runner = new Runner(io, generator);

        //when
        when(random.nextInt()).thenReturn(1);
        when(generator.quoteGenerate()).thenReturn("Get involved in the development of interesting projects!");
        when(io.consoleScanInt()).thenReturn(1, 0);
        runner.run();

        //then
        verify(io, times(1)).println("Get involved in the development of interesting projects!");
    }
}