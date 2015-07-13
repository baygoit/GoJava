package goit.anagram;

import org.junit.Assert;
import org.junit.Test;

public class AnagramTest {

    @Test
    public void whenGetAnagramThenValidOut() throws Exception {
        Anagram anagram = new Anagram();

        String result = anagram.getAnargam("qwe rty uio");

        Assert.assertEquals("Unexpected result", result, "ewq ytr oiu");
    }

    @Test
    public void whenGetAnagramNullThenEmpty() throws Exception {
        Anagram anagram = new Anagram();

        String result = anagram.getAnargam(null);

        Assert.assertNotNull("Result must be empty, not null", result);
    }
}