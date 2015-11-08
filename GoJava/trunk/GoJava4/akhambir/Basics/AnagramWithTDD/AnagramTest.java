package ua.goit.alg.anagram;

import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;

public class AnagramTest {
  @Test
  public void TestingAnagramWithSimpleSentence() throws IOException {
    Anagram anagram = new Anagram();
    String actualResult = anagram.makeAnagram("Mama Mula Ramu");
    String expectedResult = "amaM aluM umaR";
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void TestingAnagramWithSpaceInTheBeginning() throws IOException {
    Anagram anagram = new Anagram();
    String actualResult = anagram.makeAnagram("   Mama Mula Ramu");
    String expectedResult = "   amaM aluM umaR";
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void TestingAnagramWithSpaceInTheEnd() throws IOException {
    Anagram anagram = new Anagram();
    String actualResult = anagram.makeAnagram("Mama Mula Ramu   ");
    String expectedResult = "amaM aluM umaR";
    assertEquals(expectedResult, actualResult);
  }

}