package test.ua.goit.alg.xmlparser;

import static org.junit.Assert.assertEquals;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import ua.goit.alg.xmlparser.parser.Parser;

public class ParserTest {

    @Test
    public void whenCompareInside() throws IOException {
        Parser parser = new ParserBuilderForFullTesting();
        String result = parser.parse("<s><t t=\"<1\"></t></s>");
        String expectedResult = "<s><t></t></s>";
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void when2Open2Close() throws IOException {
        Parser parser = new ParserBuilderForFullTesting();
        String result = parser.parse("<s><t></t></s>");
        String expectedResult = "<s><t></t></s>";
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void whenAttr() throws IOException {
        Parser parser = new ParserBuilderForFullTesting();
        String result = parser.parse("<start atr1=\"3\"><tag></tag><tag2></tag2></start>");
        String expectedResult = "<start><tag></tag><tag2></tag2></start>";
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void whenClosableTag() throws IOException {
        Parser parser = new ParserBuilderForFullTesting();
        String result = parser.parse("<start atr1=\"3\"><tag></tag><tag2/></start>");
        String expectedResult = "<start><tag></tag><tag2></tag2></start>";
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void whenText() throws IOException {
        Parser parser = new ParserBuilderForFullTesting();
        String result = parser.parse("<start atr1=\"3\"><tag>text</tag><tag2/></start>");
        String expectedResult = "<start><tag>text</tag><tag2></tag2></start>";
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void whenFull() throws IOException {
        Parser parser = new ParserBuilderForFullTesting();
        String result = parser.parse("<?xml doctype=\"1\"?><start atr1=\"3\" atr2 = \"4\"><tag>text</tag><tag2/></start>");
        String expectedResult = "<?xml?><start><tag>text</tag><tag2></tag2></start>";
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void whenDoubleStartTag() throws IOException {
        Parser parser = new ParserBuilderForFullTesting();
        String expectedResult = "<?xml?><start>";
        String result = parser.parse("<?xml doctype=\"1\"><start atr1=\"3\" atr2 = \"4\"><?xml doctype=\"1\"><tag>text</tag><tag2/></start>");
        assertEquals(expectedResult, result);
    }

    @Test
    public void whenCloseTag_notEquals_OpenTag() throws IOException {
        Parser parser = new ParserBuilderForFullTesting();
        String expectedResult = "<s><t></o>";
        String result = parser.parse("<s><t></o></r>");
        assertEquals(expectedResult, result);
    }

    @Test
    public void attributeWithoutValue() throws IOException {
        Parser parser = new ParserBuilderForFullTesting();
        String expectedResult = "<?xml?><start>";
        String result = parser.parse("<start atr1 atr2=\"4\"></start>");
        assertEquals(expectedResult, result);
    }

    @Test
    public void parsingTwoStringsWithOneParser() throws IOException {
        Parser parser = new ParserBuilderForFullTesting();
        String result1 = parser.parse("<?xml doctype=\"1\"?><start atr1=\"3\" atr2 = \"4\"><tag>text</tag><tag2/></start>");
        String expectedResult = "<?xml?><start><tag>text</tag><tag2></tag2></start>";
        Assert.assertEquals(expectedResult, result1);

        String result2 = parser.parse("<?xml doctype=\"1\"?><start atr1=\"3\" atr2 = \"4\"><tag>text</tag><tag2/></start>");
        Assert.assertEquals(expectedResult, result2);
    }

    @Test
    public void invalidCloseTag() throws IOException {
        Parser parser = new ParserBuilderForFullTesting();
        String result = parser.parse("<s/s>");
        assertEquals("", result);
    }

    @Test
    public void invalidTagName() throws IOException {
        Parser parser = new ParserBuilderForFullTesting();
        String result = parser.parse("<C++></C++>");
        assertEquals("", result);
    }

    @Test
    public void tagNameWithInvalidSpace() throws IOException {
        Parser parser = new ParserBuilderForFullTesting();
        String result = parser.parse("<star t></start>");
        assertEquals("", result);
    }

    @Test
    public void atributesAndValues() throws IOException {
        Parser parser = new ParserBuilderForAtributeTesting();
        String result = parser.parse("<start atr1=\"3\" atr2 = \"4\"><tag>text</tag><tag2/></start>");
        String expectedResult = "<start atr1=\"3\" atr2=\"4\"><tag><tag2>";
        assertEquals(expectedResult, result);
    }
}
  
