import static org.junit.Assert.*;

public class Test {

    @org.junit.Test
    public void test() {
        assertEquals("amam alim ymar", Anagrams.changeString("mama mila ramy"));
        assertEquals("ytyd eerf", Anagrams.changeString("dyty free"));
        assertEquals("aaa bb ccc", Anagrams.changeString("aaa bb ccc"));
        assertEquals("bbaa dcba fed", Anagrams.changeString("aabb abcd def"));

    }

}
