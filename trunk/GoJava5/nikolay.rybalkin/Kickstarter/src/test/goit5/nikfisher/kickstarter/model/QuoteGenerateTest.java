package goit5.nikfisher.kickstarter.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class QuoteGenerateTest {

    class FakeRandom extends Random {

        final private List<Integer> NUMBERS;

        public FakeRandom(Integer... numbers) {
            this.NUMBERS = new LinkedList<>(Arrays.asList(numbers));
        }

        @Override
        public int nextInt(int i) {
            return NUMBERS.remove(0);
        }
    }

    @Test
    public void shouldQuoteGenerateNewQuote() {
        //given
        QuoteGenerate quoteGenerate = new QuoteGenerate(new FakeRandom(0));

        // when
        String quote1 = quoteGenerate.quoteGenerate();

        //then
        assertEquals("Get involved in the development of interesting projects!", quote1);
    }
}