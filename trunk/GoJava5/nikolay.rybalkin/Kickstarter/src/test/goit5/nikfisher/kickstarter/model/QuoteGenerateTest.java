package goit5.nikfisher.kickstarter.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class QuoteGenerateTest {

    class FakeRandom extends Random{

        private List<Integer> numbers;

        public FakeRandom(Integer... numbers){
            this.numbers = new LinkedList(Arrays.asList(numbers));
        }

        @Override
        public int nextInt(int i){
            return numbers.remove(0);
        }
    }

    @Test
    public void shouldQuoteGenerateNewQuote() throws Exception {
        //given
        QuoteGenerate quoteGenerate = new QuoteGenerate(new FakeRandom(0));

        // when
        String quote1 = quoteGenerate.quoteGenerate();

        //then
        assertEquals("Get involved in the development of interesting projects!", quote1);
    }
}